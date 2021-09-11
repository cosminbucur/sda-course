package com.sda.advanced.functional.streams.how;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// https://www.baeldung.com/java-maps-streams
public class DemoStreamsWithMaps {

    public static void main(String[] args) {
        Map<String, String> books = new HashMap<>();
        books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");
        books.put("978-0134685992", "Effective Java 2019");

        findAMatch(books).ifPresent(System.out::println);

        findMultipleMatches(books).forEach(System.out::println);

        getMapValues(books).forEach(System.out::println);
    }

    private static Optional<String> findAMatch(Map<String, String> books) {
        return books.entrySet().stream()
            .filter(e -> "Effective Java".equals(e.getValue()))
            .map(Map.Entry::getKey)
            .findFirst();
    }

    private static List<String> findMultipleMatches(Map<String, String> books) {
        return books.entrySet().stream()
            .filter(e -> e.getValue().startsWith("Effective Java"))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    private static List<String> getMapValues(Map<String, String> books) {
        return books.entrySet().stream()
            .filter(e -> e.getKey().startsWith("978-0"))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
    }

}
