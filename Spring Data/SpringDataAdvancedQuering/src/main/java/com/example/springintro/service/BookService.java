package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.repository.query.Param;

import javax.print.attribute.standard.Copies;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

   List<Book> findAllBooksByAgeRestriction(String ageRestriction);

    List<Book> findAllBooksByEditionTypeAndCopiesLessThan(String editionType, Integer copies);

    List<Book> findAllBooksByPriceLessThanOrByPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> getBooksByReleaseDateNot_Year(Integer year);

    List<Book> findBookByReleaseDateBefore(LocalDate localDate);

    List<Book> getBookByTitleContaining(String letter);

    List<Book> findAllByAuthorLastNameStartsWith(String start);

    Integer getCountOfBooksWithTitleLongerThan(@Param("length") int length);

    String getBookByTitle(final String title);

    Integer increaseCopiesForBooksReleasedAfterDate
            (@Param("date") LocalDate startDate, @Param("copies") int copiesToAdd);

    Integer removeBooksWithCopiesLessThan(@Param("copies") int numCopies);



}
