package com.bucur.spring.boot.rest.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    @Query("FROM Book b WHERE b.author=:author")
    List<Book> findByAuthorQuery(String author);
}
