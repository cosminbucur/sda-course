package com.sda.testing.tdd.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        } else if (text.contains(",")) {
            List<Integer> numbers = getNumbers(text);
            List<Integer> negatives = getNegatives(numbers);
            StringBuilder negativeStrings = getNegativeStrings(negatives);

            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("negative number not supported: " + negativeStrings);
            }
            return sumNumbers(numbers);
        } else {
            return toInt(text);
        }
    }

    private static List<Integer> getNumbers(String text) {
        String[] tokens = text.split(",|\n");

        return Arrays.stream(tokens)
                .map(Calculator::toInt)
                .collect(Collectors.toList());
    }

    private static int sumNumbers(List<Integer> numbers) {
        int result = 0;
        return numbers.stream()
                .mapToInt(integer -> result + integer)
                .sum();
    }

    private static StringBuilder getNegativeStrings(List<Integer> negatives) {
        StringBuilder negativeStrings = new StringBuilder();
        for (Integer number : negatives) {
            negativeStrings.append(number);
            if (!number.equals(negatives.get(negatives.size() - 1))) {
                negativeStrings.append(',');
            }
        }
        return negativeStrings;
    }

    private static List<Integer> getNegatives(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number < 0)
                .collect(Collectors.toList());
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}
