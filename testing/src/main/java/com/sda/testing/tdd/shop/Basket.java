package com.sda.testing.tdd.shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

    public void clear() {
        books = new ArrayList<>();
    }

    public int sumPrices() {
        int sum = books.stream()
                .map(book -> book.getPrice())
                .reduce(0, (first, second) -> first + second);

        int sum2 = books.stream()
                .mapToInt(Book::getPrice)
                .sum();
        return sum2;
    }
}
