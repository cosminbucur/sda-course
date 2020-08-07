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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final ObjectMapper jacksonObjectMapper;

    @Autowired
    BookService(BookRepository bookRepository, BookMapper bookMapper, ObjectMapper jacksonObjectMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    // TODO: implement findAll
    public List<BookResponse> findAll() {
        log.debug("finding all books");
        return bookRepository.findAll().stream()
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    // TODO: implement findById
    public BookResponse findById(long id) {
        log.debug("finding book by id: {}", id);
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
            new NotFoundException("book not found")));
    }

    // TODO: implement save
    public BookResponse save(BookRequest createBookRequest) {
        log.debug("saving book: {}", createBookRequest);
        // TODO: validate book details

        // TODO: convert book request (DTO) to book (ENTITY)
        Book account = bookMapper.toEntity(createBookRequest);

        // TODO: save book in db using repository
        Book newBook = bookRepository.save(account);
        // Hibernate: insert into book (id, title, author, published) values (null, ?, ?, ?)

        // TODO: convert back to response (DTO)
        return bookMapper.toDto(newBook);
    }

    // TODO: implement update
    public BookResponse update(Book updateRequest, long id) {
        log.debug("updating book with id: {} and request body: {}", id, updateRequest);
        Book bookToUpdate = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("book not found"));

        // TODO: validate book details
        bookMapper.map(updateRequest, bookToUpdate);

        // TODO: save book in db using repository
        Book updatedBook = bookRepository.save(bookToUpdate);
        // Hibernate: insert into book (id, title, author, published) values (null, ?, ?, ?)

        // TODO: convert back to response (DTO)
        return bookMapper.toDto(updatedBook);
    }

    // FIXME: implement partial update
    public BookResponse partialUpdate(Map<String, Object> updates, long id) {
        log.debug("patching book with id: {} and request body: {}", id, updates);
        // De-serialise request body into a DTO
        // Run some sort of validation
        // Load entity being updated
        // Copy fields that change over to the entity with the help of a Model Mapper
        // Save

        try {
            Book account = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

            // Jackson deserializes and copies value to the already initialised DTO
            jacksonObjectMapper.readerForUpdating(account)
                .readValue(jacksonObjectMapper.writeValueAsBytes(updates));

            // TODO: save book in db using repository
            Book updatedBook = bookRepository.save(account);
            // Hibernate: insert into book (id, title, author, published) values (null, ?, ?, ?)

            // TODO: convert book details (DTO) to book (ENTITY)
            return bookMapper.toDto(updatedBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO: implement delete
    public void delete(long id) {
        log.debug("deleting book with id: {}", id);
        bookRepository.deleteById(id);
    }

    // TODO: implement findByAuthor using filter
    public List<BookResponse> findByAuthor(String author) {
        log.debug("finding books by author: {}", author);
        return bookRepository.findAll()
            .stream()
            .filter(book -> book.getAuthor().equals(author))
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

}
