package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.Copies;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllBooksByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    @Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) <> :year")
    List<Book> getBooksByReleaseDateNot_Year(@Param("year")  int year);

    List<Book> findBookByReleaseDateBefore(LocalDate localDate);

    List<Book> findBookByTitleContaining(String letter);

    List<Book> findAllByAuthorLastNameStartsWith(String start);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :length")
    Integer getCountOfBooksWithTitleLongerThan(@Param("length") int length);


    @Query("SELECT b.title,b.editionType,b.ageRestriction,b.price" +
            " FROM Book as b WHERE b.title = :title ")
    String getBookByTitle(final String title);

    @Modifying
    @Transactional
    @Query("UPDATE Book AS b SET b.copies = b.copies + :copies WHERE b.releaseDate > :date")
    Integer increaseCopiesForBooksReleasedAfterDate
            (@Param("date") LocalDate startDate, @Param("copies") int copiesToAdd);


    @Modifying
    @Transactional
    @Query("DELETE FROM Book AS b WHERE b.copies < :copies")
    Integer removeBooksWithCopiesLessThan(@Param("copies") int numCopies);










}
