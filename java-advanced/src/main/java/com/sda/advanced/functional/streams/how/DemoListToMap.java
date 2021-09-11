package com.sda.advanced.functional.streams.how;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://javarevisited.blogspot.com/2016/04/10-examples-of-converting-list-to-map.html
public class DemoListToMap {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(new Book("java7", "222"), new Book("java8", "333"));
        Map<String, Book> bookMap = toMap(books);
        bookMap.forEach((isbn, book) -> System.out.println(isbn + " - " + book.getTitle()));

        Map<String, Book> streamMap = toMapWithStream(books);
        streamMap.forEach((isbn, book) -> System.out.println(isbn + " - " + book.getTitle()));

        List<String> cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");
        Map<String, Object> mapWithNoDuplicates = convertListWithDuplicatesToMap(cards);
        System.out.println("map: " + mapWithNoDuplicates);

        listToMapWithOrderPreservation();
    }

    private static Map<String, Book> toMap(List<Book> books) {
        final Map hashMap = new HashMap<>();
        for (final Book book : books) {
            hashMap.put(book.getIsbn(), book);
        }
        return hashMap;
    }

    private static Map<String, Book> toMapWithStream(List<Book> books) {
        return books.stream()
            .collect(Collectors.toMap(book -> book.getIsbn(), book -> book));
    }

    private static Map<String, Object> convertListWithDuplicatesToMap(List<String> cards) {
        return cards.stream()
            .collect(Collectors.toMap(Function.identity(), String::length, (length1, length2) -> length1));
    }

    private static void listToMapWithOrderPreservation() {
        List<String> hostingProviders = Arrays.asList("Bluehost", "GoDaddy", "Amazon AWS", "LiquidWeb", "FatCow");
        System.out.println("list: " + hostingProviders);

        Map<String, Integer> cards2Length = hostingProviders.stream()
            .collect(Collectors.toMap(Function.identity(),
                String::length,
                (e1, e2) -> e1,
                LinkedHashMap::new));
        System.out.println("map: " + cards2Length);

    }
}

class Book {

    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }
}
