package com.example.bookdemo.service;

import com.example.bookdemo.Entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllByReleaseDateAfter(LocalDate parse);

    List<Book> findAllByReleaseDateBefore(LocalDate parse);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);
}
