package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import static com.example.springintro.model.entity.EditionType.GOLD;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();


        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
     //   printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");


        //1. Books Titles by Age Restriction
//       this.bookService.findAllBooksByAgeRestriction("miNor");
        //2. Golden Books
//       this.bookService.findAllBooksByEditionTypeAndCopiesLessThan("Gold",5000);
        //3. Books by Price
//        this.bookService.
//                findAllBooksByPriceLessThanOrByPriceGreaterThan
//                        (BigDecimal.valueOf(5),BigDecimal.valueOf(40));
        //4. Not Released Books
//        this.bookService.getBooksByReleaseDateNot_Year(2000);
//        this.bookService.getBooksByReleaseDateNot_Year(1998);
        //5. Books Released Before Date
//        this.bookService.findBookByReleaseDateBefore(LocalDate.parse("1992-04-12"));
        //6. Authors Search
//        this.authorService.getAuthorByFirstNameEndingWith("e");
//        this.authorService.getAuthorByFirstNameEndingWith("dy");
        //7. Books Search
//        this.bookService.getBookByTitleContaining("sK");
//        this.bookService.getBookByTitleContaining("WOR");
        //8. Book Titles Search
//        this.bookService.findAllByAuthorLastNameStartsWith("Ric");
//        this.bookService.findAllByAuthorLastNameStartsWith("gr");
        //9. Count Books
//        this.bookService.getCountOfBooksWithTitleLongerThan(12);
//        this.bookService.getCountOfBooksWithTitleLongerThan(40);
        //10. Total Book Copies
//        this.authorService.getAuthorsByBookCopiesCount();
        //11. Reduced Book
//        this.bookService.getBookByTitle("Things Fall Apart");

        //12.Increase Book Copies
//        this.bookService.
//                increaseCopiesForBooksReleasedAfterDate
//                        (LocalDate.parse("2005-10-12"),
//                100);
//        this.bookService.
//                increaseCopiesForBooksReleasedAfterDate
//                        (LocalDate.parse("2013-06-06"),
//                                44);

        //13.Remove Books
// this.bookService.removeBooksWithCopiesLessThan(10000);
        //14.Stored Procedure
//        this.authorService.getAuthorBooksCount("Amanda Rice");
//        this.authorService.getAuthorBooksCount("Christina Jordan");
//        this.authorService.getAuthorBooksCount("Wanda Morales");
//

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }



}
