package com.example.springintro.service.impl;

import com.example.springintro.model.entity.Author;
import com.example.springintro.repository.AuthorRepository;
import com.example.springintro.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1,
                        authorRepository.count() + 1);

        return authorRepository
                .findById(randomId)
                .orElse(null);
    }

   

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooks() {
        return authorRepository
                .findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> getAuthorByFirstNameEndingWith(String letter) {
        List<Author> authorByFirstNameEndingWith
                = authorRepository.findAuthorByFirstNameEndingWith(letter);

        authorByFirstNameEndingWith.stream().forEach(el->
                System.out.println(el.getFirstName() + " " + el.getLastName()));


        return authorByFirstNameEndingWith;
    }


    @Override
    public List<String> getAuthorsByBookCopiesCount() {
        List<String> list = this.authorRepository
                .getAuthorsByBooksCopies()
                .stream()
                .map(el -> (String) el)
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        return list;
    }
    @Override
    public Integer getAuthorBooksCount(String fullName) {

        int booksCount = authorRepository.getAuthorBooksCount(fullName);

       System.out.println(fullName + " has written " + booksCount + " books");

        return booksCount;
    }

}
