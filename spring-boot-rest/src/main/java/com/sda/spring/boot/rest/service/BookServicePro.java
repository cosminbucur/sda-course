package com.sda.spring.boot.rest.service;

import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.exception.NotFoundException;
import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.model.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServicePro implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServicePro.class);

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final ObjectMapper jacksonObjectMapper;

    @Autowired
    public BookServicePro(BookRepository bookRepository, BookMapper bookMapper, ObjectMapper jacksonObjectMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    @Override
    public List<BookResponse> findAll() {
        log.debug("finding all books");

        return bookRepository.findAll().stream()
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
        log.debug("finding book by id: {}", id);

        return bookRepository.findById(id)
            .map(bookMapper::toDto)
            .orElseThrow(() -> new NotFoundException("book not found"));
    }

    @Override
    public BookResponse save(BookRequest createBookRequest) {
        log.debug("saving book: {}", createBookRequest);

        boolean exists = bookRepository.findByTitle(createBookRequest.getTitle()).isPresent();
        if (exists) {
            throw new NotFoundException("duplicate book");
        }

        Book book = bookMapper.toEntity(createBookRequest);
        Book newBook = bookRepository.save(book);
        return bookMapper.toDto(newBook);
    }

    @Override
    public BookResponse update(Long id, BookRequest updateRequest) {
        log.debug("updating book with id: {} and request body: {}", id, updateRequest);

        return bookRepository.findById(id)
            .map(book -> bookMapper.toEntity(book, updateRequest))
            .map(bookRepository::save)
            .map(bookMapper::toDto)
            .orElseThrow(() -> new NotFoundException("book not found"));
    }

    @Override
    public BookResponse partialUpdate(Long id, Map<String, Object> updates) {
        log.debug("patching book with id: {} and request body: {}", id, updates);
        // De-serialise request body into a DTO
        // Run some sort of validation
        // Load entity being updated
        // Copy fields that change over to the entity with the help of a Model Mapper
        // Save

        try {
            Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("book not found"));

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

    @Override
    public void delete(Long id) {
        log.debug("deleting book with id: {}", id);

        bookRepository.findById(id)
            .map(book -> {
                bookRepository.deleteById(id);
                return book;
            })
            .orElseThrow(() -> new NotFoundException("book not found"));
    }

    // find using filter
    @Override
    public List<BookResponse> findByAuthor(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findAll()
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    // find using derived query
    @Override
    public List<BookResponse> findByAuthorDerived(String author) {
        log.debug("finding books by author: {}", author);
        return bookRepository.findByAuthor(author)
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    // find using JPQL
    @Override
    public List<BookResponse> findByAuthorQuery(String author) {
        log.debug("finding books by author: {}", author);

        return bookRepository.findByAuthor(author)
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

}
