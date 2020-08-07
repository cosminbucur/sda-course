package com.bucur.functional.streams.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoEx1 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Sarah");
        names.add("Mark");
        names.add("Tyla");
        names.add("Ellisha");
        names.add("Eamonn");

//        names.sort();

//        printNamesStartingWithE(names);
//        printNamesUppercase(names);
        processNames(names);

        List<Integer> numbers =
            Arrays.asList(1, 4, 2346, 123, 76, 11, 0, 0, 62, 23, 50);
//        numbers.sort((o1, o2) -> o1 > o2);

        printValuesGreaterThan30AndLowerThan200(numbers);

    }

    private static void printNamesStartingWithE(List<String> persons) {
        persons.stream()
            .filter(name -> name.startsWith("E"))
            .forEach(System.out::println);
    }

    private static void printNamesUppercase(List<String> persons) {
        persons.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }

    private static void processNames(List<String> persons) {
        persons.stream()
            .map(name -> name.substring(1, name.length() - 1))
            .sorted()
            .forEach(System.out::println);
    }

    private static void printValuesGreaterThan30AndLowerThan200(List<Integer> persons) {
        persons.stream()
            .filter(value -> value > 30)
            .filter(value -> value < 200)
            .forEach(System.out::println);
    }
}
