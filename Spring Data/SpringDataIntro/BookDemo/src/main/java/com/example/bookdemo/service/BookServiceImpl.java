package com.example.bookdemo.service;

import com.example.bookdemo.Entity.Author;
import com.example.bookdemo.Entity.Book;
import com.example.bookdemo.Entity.Category;
import com.example.bookdemo.Enum.AgeRestriction;
import com.example.bookdemo.Enum.EditionType;
import com.example.bookdemo.repository.BookRepository;
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

    private static  final String BOOK_PATH = "src/main/resources/files/books.txt";

    private BookRepository bookRepository;

    private AuthorService authorService;

    private CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedBooks() throws IOException {
        if(bookRepository.count() > 0){
            return;
        }

        Files.readAllLines(Path.of(BOOK_PATH))
                .stream()
                .forEach(lineBook->{

                    String [] infoBook = lineBook.split("\\s+");

                    Book book = createBook(infoBook);


                    bookRepository.save(book);
                });


    }

    private Book createBook(String[] infoBook) {

        EditionType editionType = EditionType.values()[Integer.parseInt(infoBook[0])];
        LocalDate releaseDate = LocalDate.parse(infoBook[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(infoBook[2]);
        BigDecimal price = new BigDecimal(infoBook[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(infoBook[4])];
        String title = Arrays.stream(infoBook).skip(5).collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();


        Book book = new Book(editionType,releaseDate,copies,price,ageRestriction,title,
                author,categories);

//        book.setEditionType(editionType);
//        book.setReleaseDate(releaseDate);
//        book.setCopies(copies);
//        book.setPrice(price);
//        book.setAgeRestriction(ageRestriction);
//        book.setTitle(title);
//        book.setAuthor(author);
//        book.setCategories(categories);

        return book;
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {
        List<Book> dateAfter = bookRepository.findAllByReleaseDateAfter(date);

        dateAfter.stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return dateAfter;
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(LocalDate date) {
        List<Book> dateBefore = bookRepository.findAllByReleaseDateBefore(date);

        dateBefore
                .stream()
                .map(book ->
                    String.format("%s %s",book.getAuthor().getFirstName(),
                    book.getAuthor().getLastName()))
                .distinct()
                .forEach(System.out::println);


        return dateBefore;
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
}
