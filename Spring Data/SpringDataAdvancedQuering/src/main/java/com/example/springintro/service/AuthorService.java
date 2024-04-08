package com.example.springintro.service;

import com.example.springintro.model.entity.Author;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<Author> getAuthorByFirstNameEndingWith(String letter);


    List<String> getAuthorsByBookCopiesCount();

    Integer getAuthorBooksCount(String fullName);
}
