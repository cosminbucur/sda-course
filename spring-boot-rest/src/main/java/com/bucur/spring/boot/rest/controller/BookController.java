package com.bucur.spring.boot.rest.controller;

import com.bucur.spring.boot.rest.model.Book;
import com.bucur.spring.boot.rest.model.BookRepository;
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
//@RequestMapping("/api")
//@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        logger.info("Get all Books...");

        List<Book> list = new ArrayList<>();
        Iterable<Book> customers = bookRepository.findAll();

        customers.forEach(list::add);
        return list;
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        logger.info("Create Book: {} ...", book.getTitle());

        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        logger.info("Get Book by ID = {}...", id);

        Optional<Book> bookData = bookRepository.findById(id);
        return bookData
            .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        logger.info("Update Book with ID = {}...", id);

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

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        logger.info("Delete Book with ID = {}...", id);

        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>("Book has been deleted!", HttpStatus.OK);
    }
}
