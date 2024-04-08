package com.example.bookdemo;

import com.example.bookdemo.service.AuthorService;
import com.example.bookdemo.service.BookService;
import com.example.bookdemo.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private final CategoryService categoryService;

    private final AuthorService authorService;

    private final BookService bookService;

    public ConsoleRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {

        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

//        bookService.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));
//        bookService.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

//        printAllAuthorsAndNumberOfTheirBooks();
 //       printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");


    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }
}
