package com.example.bookdemo.service;

import com.example.bookdemo.Entity.Author;
import com.example.bookdemo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHOR_PATH = "src/main/resources/files/authors.txt";


    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors() throws IOException {

        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHOR_PATH))
                .stream()
                .forEach(line -> {
                    String[] authorsName = line.split("\\s+");
                    String first = authorsName[0];
                    String last = authorsName[1];

                    Author author = new Author();

                    author.setFirstName(first);
                    author.setLastName(last);

                    authorRepository.save(author);


                });

    }

    @Override
    public Author getRandomAuthor() {

        long id = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);

        return authorRepository
                .findById(id)
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

}
