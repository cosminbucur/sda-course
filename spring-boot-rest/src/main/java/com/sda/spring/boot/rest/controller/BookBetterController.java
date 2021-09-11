package com.sda.spring.boot.rest.controller;

import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.model.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8082")
//@RequestMapping(BookBetterController.API_BOOKS)
//@RestController
public class BookBetterController {

    public static final String API_BOOKS = "/api/books";
    private static final Logger log = LoggerFactory.getLogger(BookBetterController.class);

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookBetterController(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        log.info("Get all Books...");

        List<Book> list = new ArrayList<>();
        Iterable<Book> customers = bookRepository.findAll();

        customers.forEach(list::add);
        return list;
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        log.info("Create Book: {} ...", book.getTitle());

        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        log.info("Get Book by ID = {}...", id);

        return bookRepository.findById(id)
            .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        log.info("Update Book with ID = {}...", id);

        Optional<Book> bookData = bookRepository.findById(id);
        if (bookData.isPresent()) {
            Book savedBook = bookData.get();
            savedBook.setTitle(book.getTitle());
            savedBook.setAuthor(book.getAuthor());
            savedBook.setPublished(book.getPublished());

            Book updatedBook = bookRepository.save(savedBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        log.info("Delete Book with ID = {}...", id);

        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>("Book has been deleted!", HttpStatus.OK);
    }
}
