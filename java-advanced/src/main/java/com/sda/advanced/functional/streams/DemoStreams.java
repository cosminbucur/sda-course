package com.sda.advanced.functional.streams;

// https://www.baeldung.com/java-8-streams

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoStreams {

    public static void main(String[] args) {

        // empty stream
        Stream<String> streamEmpty = Stream.empty();

        streamOfArray();

        streamBuilder();

        streamIterate();

        streamOfString();
    }

    private static void streamOfArray() {
        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    }

    private static void streamBuilder() {
        Stream<String> streamBuilder =
            Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        streamBuilder.forEach(System.out::println);
    }

    private static void streamIterate() {
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);
        streamIterated.forEach(System.out::println);
    }

    private static void streamOfString() {
        IntStream streamOfChars = "abc".chars();

        Stream<String> streamOfString =
            Pattern.compile(", ").splitAsStream("a, b, c");
        streamOfString.forEach(System.out::println);
    }

    // use empty stream instead
    private Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

}
