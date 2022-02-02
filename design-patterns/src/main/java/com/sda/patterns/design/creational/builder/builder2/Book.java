package com.sda.patterns.design.creational.builder.builder2;

import java.time.Year;

public class Book {

    private final String isbn;
    private final String title;
    private final String author;
    private final Year published;
    private final String description;

    public Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.published = builder.published;
        this.description = builder.description;
    }

    public static class Builder {
        private String isbn;
        private String title;
        private String author;
        private Year published;
        private String description;

        // mandatory fields
        public Builder(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder published(Year published) {
            this.published = published;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        // build method
        public Book build() {
            return new Book(this);
        }
    }
}
