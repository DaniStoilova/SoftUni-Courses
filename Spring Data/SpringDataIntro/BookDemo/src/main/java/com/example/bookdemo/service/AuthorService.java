package com.example.bookdemo.service;

import com.example.bookdemo.Entity.Author;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();


    List<String> getAllAuthorsOrderByCountOfTheirBooks();
}
