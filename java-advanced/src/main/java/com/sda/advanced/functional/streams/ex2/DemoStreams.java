package com.sda.advanced.functional.streams.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreams {

    // Get the unique names in uppercase of the first
    // 15 book authors that are 50 years old or over
    public static void main(String[] args) {
        wrongWay();
        coolWay();
    }

    private static void wrongWay() {
        List<Book> library = new ArrayList<>();
        List<String> names = library.stream()           // Stream<Book>
            .map(book -> book.getAuthor())              // Stream<Author>
            .filter(author -> author.getAge() >= 50)    // Stream<Author>
            .distinct()                                 // Stream<Author>
            .limit(15)                                  // Stream<Author>
            .map(author -> author.getName())            // Stream<String>
            .map(name -> name.toUpperCase())            // Stream<String>
            .collect(Collectors.toList());              // List<String>

        names.forEach(name -> System.out.println(name));
    }

    private static void coolWay() {
        List<Book> library = new ArrayList<>();

        Predicate<Author> middleAgedAuthors = author -> author.getAge() >= 50;

        Stream<Author> authorStream = library.stream()
            .map(Book::getAuthor);

        Stream<Author> filteredAuthors = authorStream
            .filter(middleAgedAuthors)
            .distinct()
            .limit(15);

        Stream<String> authorNames = filteredAuthors
            .map(Author::getName);

        List<String> names = authorNames
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
