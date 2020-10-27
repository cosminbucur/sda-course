package com.bucur.spring.boot.rest.controller;

import com.bucur.spring.boot.rest.dto.BookRequest;
import com.bucur.spring.boot.rest.dto.BookResponse;
import com.bucur.spring.boot.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping(BookBestController.API_BOOKS)
@RestController
public class BookBestController {

    public static final String API_BOOKS = "/api/books";

    private final BookService bookService;

    @Autowired
    public BookBestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest bookRequest) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(bookService.save(bookRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/search-slow")
    public ResponseEntity<List<BookResponse>> findByAuthor(@RequestParam("author") String author) {
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    @GetMapping("/search-easy")
    public ResponseEntity<List<BookResponse>> findByAuthorDerived(@RequestParam("author") String author) {
        return ResponseEntity.ok(bookService.findByAuthorDerived(author));
    }

    @GetMapping("/search-custom")
    public ResponseEntity<List<BookResponse>> findByAuthorQuery(@RequestParam("author") String author) {
        return ResponseEntity.ok(bookService.findByAuthorQuery(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(
        @PathVariable("id") Long id,
        @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.update(id, bookRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> partialUpdate(
        @PathVariable("id") Long id,
        @RequestBody Map<String, Object> bookRequest) {
        return ResponseEntity.ok(bookService.partialUpdate(id, bookRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
