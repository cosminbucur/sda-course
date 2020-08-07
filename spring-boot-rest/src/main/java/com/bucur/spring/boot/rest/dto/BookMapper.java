package com.bucur.spring.boot.rest.dto;

import com.bucur.spring.boot.rest.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Component
public class BookMapper {

    public BookResponse toDto(Book book) {
        BookResponse dto = new BookResponse();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPublished(book.getPublished());
        return dto;
    }

    public Book toEntity(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublished(bookRequest.getPublished());
        return book;
    }

    public void map(Book updateRequest, Book bookToUpdate) {
        if (!StringUtils.isEmpty(updateRequest.getTitle())) {
            bookToUpdate.setTitle(updateRequest.getTitle());
        }

        if (!StringUtils.isEmpty(updateRequest.getAuthor())) {
            bookToUpdate.setAuthor(updateRequest.getAuthor());
        }

        if (updateRequest.getPublished() != null && updateRequest.getPublished().isBefore(LocalDate.now())) {
            bookToUpdate.setPublished(updateRequest.getPublished());
        }
    }
}
