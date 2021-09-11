package com.sda.testing.tdd.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator4 {

    static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        } else if (text.contains(",")) {
            String[] tokens = text.split(",|\n");

            List<Integer> numbers = Arrays.stream(tokens)
                    .map(Calculator4::toInt)
                    .collect(Collectors.toList());

            List<Integer> negatives = numbers.stream()
                    .filter(number -> number < 0)
                    .collect(Collectors.toList());

            StringBuilder negativeStrings = new StringBuilder();
            for (Integer number : negatives) {
                negativeStrings.append(number);
                if (!number.equals(negatives.get(negatives.size() - 1))) {
                    negativeStrings.append(',');
                }
            }

            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("negative number not supported: " + negativeStrings);
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
