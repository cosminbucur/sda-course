package com.bucur.spring.boot.rest.service;

import com.bucur.spring.boot.rest.dto.BookMapper;
import com.bucur.spring.boot.rest.dto.BookRequest;
import com.bucur.spring.boot.rest.dto.BookResponse;
import com.bucur.spring.boot.rest.exception.NotFoundException;
import com.bucur.spring.boot.rest.model.Book;
import com.bucur.spring.boot.rest.model.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Service
public class BookServiceNoob implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceNoob.class);

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final ObjectMapper jacksonObjectMapper;

    @Autowired
    public BookServiceNoob(BookRepository bookRepository, BookMapper bookMapper, ObjectMapper jacksonObjectMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    public List<BookResponse> findAll() {
        log.debug("finding all books");

        return bookRepository.findAll().stream()
            .map(book -> bookMapper.toDto(book))
            .collect(Collectors.toList());
    }

    public BookResponse findById(Long id) {
        log.debug("finding book by id: {}", id);

        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("book not found"));
        return bookMapper.toDto(book);
    }

    public BookResponse save(BookRequest createBookRequest) {
        log.debug("saving book: {}", createBookRequest);

        Book book = bookMapper.toEntity(createBookRequest);
        Book newBook = bookRepository.save(book);
        return bookMapper.toDto(newBook);
    }

    public BookResponse update(Long id, BookRequest updateRequest) {
        log.debug("updating book with id: {} and request body: {}", id, updateRequest);

        Book bookToUpdate = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("book not found"));

        bookMapper.toEntity(bookToUpdate, updateRequest);
        Book updatedBook = bookRepository.save(bookToUpdate);
        return bookMapper.toDto(updatedBook);
    }

    public BookResponse partialUpdate(Long id, Map<String, Object> updates) {
        log.debug("patching book with id: {} and request body: {}", id, updates);
        // De-serialise request body into a DTO
        // Run some sort of validation
        // Load entity being updated
        // Copy fields that change over to the entity with the help of a Model Mapper
        // Save

        try {
            Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

            // Jackson deserializes and copies value to the already initialised DTO
            jacksonObjectMapper.readerForUpdating(book)
                .readValue(jacksonObjectMapper.writeValueAsBytes(updates));

            Book updatedBook = bookRepository.save(book);

            return bookMapper.toDto(updatedBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Long id) {
        log.debug("deleting book with id: {}", id);

        bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("book not found"));
        bookRepository.deleteById(id);
    }

    // find using filter
    public List<BookResponse> findByAuthor(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findAll()
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    // find using derived query
    public List<BookResponse> findByAuthorDerived(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findByAuthor(author)
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    // find using JPQL
    public List<BookResponse> findByAuthorQuery(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findByAuthor(author)
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }
}
