package com.sda.advanced.functional.streams.why;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreams {

    // Get the unique names in uppercase of the first
    // 15 book authors that are 50 years old or over
    public static void main(String[] args) {
        easyToRead();
    }

    public static void splitEachOperation() {
        List<Book> library = new ArrayList<>();

        // DONE: create a stream from the list and apply these changes:

        // convert list to Stream<Book>
        Stream<Book> streamOfBooks = library.stream();  // book1 book2 book3 ...

        // get the authors of books
        Stream<Author> authorStream = streamOfBooks         // author1 author2 ...
                .map(book -> book.getAuthor());

        // filter the authors by age
        Predicate<Author> authorsOlderThan50 = author -> author.getAge() >= 50;
        authorStream
                .filter(authorsOlderThan50);        // author1 author1 author2 ...

        // filter the unique authors
        authorStream.distinct();            // author1 author2 ...

        // filter for the first 15 authors
        authorStream.limit(15);             // author1 author2 ...

        // get the names of the authors
        Stream<String> namesStream = authorStream
                .map(author -> author.getName());       // alex paul ana ...

        // convert the names to uppercase
        namesStream
                .map(name -> name.toUpperCase());       // ALEX PAUL ANA ...

        // save results into a new list
        List<String> namesWithUppercase = namesStream
                .collect(Collectors.toList());
    }

    public static void oneLine() {
        List<Book> library = new ArrayList<>();

        Predicate<Author> authorsOlderThan50 = author -> author.getAge() >= 50;
        List<String> namesWithUppercase = library.stream()  // book1 book2 book3 ...
                .map(book -> book.getAuthor())  // author1 author2 ...
                .filter(authorsOlderThan50) // author1 author1 author2 ...
                .distinct() // author1 author2 ...
                .limit(15)  // author1 author2 ...
                .map(author -> author.getName())    // alex paul ana ...
                .map(name -> name.toUpperCase())       // ALEX PAUL ANA ...
                .collect(Collectors.toList());
    }

    public static void easyToRead() {
        List<Book> library = createLibrary();

        Predicate<Author> authorsOlderThan50 = author -> author.getAge() >= 50;

        Stream<Author> authorStream = library.stream()
                .map(book -> book.getAuthor())
                .filter(authorsOlderThan50)
                .distinct()
                .limit(15);

        Stream<String> nameStream = authorStream
                .map(author -> author.getName())
                .map(name -> name.toUpperCase());

        List<String> namesWithUppercase = nameStream.collect(Collectors.toList());
        System.out.println(namesWithUppercase);
    }

    public static List<Book> createLibrary() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Karamazov brothers", new Author("Fyodor Dostoievsky", 70)));
        books.add(new Book("The metamorphosis", new Author("Franz Kafka", 60)));
        books.add(new Book("Game of thrones", new Author("George Martin", 40)));

        return books;
    }

}
