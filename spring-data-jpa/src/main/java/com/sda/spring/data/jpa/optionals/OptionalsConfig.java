package com.sda.spring.data.jpa.optionals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class OptionalsConfig {

    private static final Logger log = LoggerFactory.getLogger(OptionalsConfig.class);

    @Autowired
    private BookRepository bookRepository;

    @Bean
    public CommandLineRunner optionalsData() {
        return args -> {
            Book book = createBook();
            Book savedBook = bookRepository.save(book);

            findBookUsingOptionalGet(savedBook.getId());

            findBookUsingOptionalOrElseThrow(savedBook.getId());
        };
    }

    private Book createBook() {
        Book book = new Book();
        book.setTitle("Game of thrones");
        book.setAuthor("George Martin");
        book.setPublished(LocalDate.now());
        return book;
    }

    private void findBookUsingOptionalGet(Long id) {
        // print book from db
        Optional<Book> savedBookOptional =
                bookRepository.findById(id);

        Book savedBook = null;
        if (savedBookOptional.isPresent()) {
            savedBook = savedBookOptional.get();
        }
        log.info("saved book: {}", savedBook);
    }

    private void findBookUsingOptionalOrElseThrow(Long id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

        log.info("--- saved book: {}", foundBook);
    }

}
