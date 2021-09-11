package com.sda.testing.tdd.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculator3 {

    static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        } else if (text.contains(",")) {
            String[] tokens = text.split(",|\n");

            Function<String, Integer> toIntFunction = Calculator3::toInt;
            List<Integer> numbers = Arrays.stream(tokens)
                    .map(toIntFunction)
                    .collect(Collectors.toList());

            List<Integer> negatives = numbers.stream()
                    .filter(number -> number < 0)
                    .collect(Collectors.toList());

            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("negative number not supported: " + negatives.get(0));
            }

            int result = 0;
            return numbers.stream()
                    .mapToInt(integer -> result + integer)
                    .sum();
        } else {
            return toInt(text);
        }
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}
