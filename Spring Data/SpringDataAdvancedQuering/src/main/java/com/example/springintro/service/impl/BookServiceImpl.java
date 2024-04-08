package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllBooksByAgeRestriction(String ageRestriction) {

        List<Book> allBooksByAgeRestriction =
                bookRepository.findAllBooksByAgeRestriction
                        (AgeRestriction.valueOf(ageRestriction.toUpperCase()));

        allBooksByAgeRestriction.stream().map(Book::getTitle)
                .forEach(System.out::println);
        return allBooksByAgeRestriction;
    }

    @Override
    public List<Book> findAllBooksByEditionTypeAndCopiesLessThan(String editionType, Integer copies) {
        List<Book> books = bookRepository.
                findAllBooksByEditionTypeAndCopiesLessThan
                        (EditionType.valueOf(editionType.toUpperCase()), copies);

        books.stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return books;

    }

    @Override
    public List<Book> findAllBooksByPriceLessThanOrByPriceGreaterThan
            (BigDecimal lower, BigDecimal higher) {
        List<Book> allBooksByTitleAndPrice =
                bookRepository.findAllBooksByPriceLessThanOrPriceGreaterThan(lower, higher);

        allBooksByTitleAndPrice.stream().
                forEach(el->System.out.println(el.getTitle() + " - " + "$"+el.getPrice()));

        return allBooksByTitleAndPrice;
    }

    @Override
    public List<Book> getBooksByReleaseDateNot_Year(Integer year) {
        List<Book>books =  bookRepository.
                getBooksByReleaseDateNot_Year(year);

        books.stream()
                .map(Book::getTitle).forEach(System.out::println);

        return books;

    }

    @Override
    public List<Book> findBookByReleaseDateBefore(LocalDate localDate) {
        List<Book> bookByReleaseDateBefore
                = bookRepository.findBookByReleaseDateBefore(localDate);

        bookByReleaseDateBefore.stream().forEach(el->
                System.out.println
                        (el.getTitle()+ " " +
                                el.getEditionType() + " " + el.getPrice()));

        return bookByReleaseDateBefore;
    }

    @Override
    public List<Book> getBookByTitleContaining(String letter) {
        List<Book> bookByTitleContaining = bookRepository.findBookByTitleContaining(letter);

        bookByTitleContaining.stream().map(Book::getTitle).forEach(System.out::println);

     return bookByTitleContaining;

    }

    @Override
    public List<Book> findAllByAuthorLastNameStartsWith(String start) {

        List<Book> booksTitleAndAuthorLastNameStartsWith =
                bookRepository.findAllByAuthorLastNameStartsWith(start);
        booksTitleAndAuthorLastNameStartsWith.stream()
                .forEach(el->
                System.out.println(el.getTitle() + " " + "(" +el.getAuthor().getFirstName()
                        +" "+el.getAuthor().getLastName() +")"));

        return booksTitleAndAuthorLastNameStartsWith;
    }

    @Override
    public Integer getCountOfBooksWithTitleLongerThan(int length) {

        Integer countOfBooksWithTitleLongerThan =
                bookRepository.getCountOfBooksWithTitleLongerThan(length);
        System.out.println(countOfBooksWithTitleLongerThan);

        return countOfBooksWithTitleLongerThan;
    }

    @Override
    public String getBookByTitle(String title) {
        String bookByTitle = bookRepository.getBookByTitle(title);

        System.out.println(bookByTitle.replace(","," "));

        return bookByTitle;
    }

    @Override
    public Integer increaseCopiesForBooksReleasedAfterDate(LocalDate startDate, int copiesToAdd) {

        Integer book = this.bookRepository
                .increaseCopiesForBooksReleasedAfterDate(startDate, copiesToAdd);


        System.out.println(book * copiesToAdd);

        return book * copiesToAdd;

    }

    @Override
    public Integer removeBooksWithCopiesLessThan(int numCopies) {
        Integer count = bookRepository.removeBooksWithCopiesLessThan(numCopies);

        System.out.println(count);

        return count;
    }




    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
