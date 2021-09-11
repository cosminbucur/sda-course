package com.sda.advanced.functional.streams.how;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.baeldung.com/java-stream-sum
public class DemoStreamSum {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // use Stream.reduce()
        Integer sumJava = numbers.stream()
            .reduce(0, (a, b) -> Integer.sum(a, b));

        // use Stream.reduce()
        Integer sumReduce = numbers.stream()
            .reduce(0, (a, b) -> a + b);

        // use Stream.collect()
        Integer sumCollect = numbers.stream()
            .collect(Collectors.summingInt(number -> number.intValue()));

        // use IntStream.sum()
        Integer sumStream = numbers.stream()
            .mapToInt(number -> number.intValue())
            .sum();

        // stream#sum with Map
        Map<Object, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        Integer sumMap = map.values()
            .stream()
            .mapToInt(number -> Integer.valueOf(number))
            .sum();

        String inputText = "Item1 10 Item2 25 Item3 30 Item4 45";
        long count = Arrays.stream(inputText.split(" "))
            .count();
        System.out.println(count);
    }
}
