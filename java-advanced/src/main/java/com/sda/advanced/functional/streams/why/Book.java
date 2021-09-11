package com.sda.advanced.functional.streams.why;

public class Book {

    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return this.author;
    }
}
