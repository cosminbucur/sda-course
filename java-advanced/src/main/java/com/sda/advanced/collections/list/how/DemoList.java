package com.sda.advanced.collections.list.how;

import java.util.ArrayList;
import java.util.List;

public class DemoList {

    public static void main(String[] args) {
        List<String> listOfCountries = createListOfCountries();
        listOperations(listOfCountries);
        int occurrencesOfRomania = countOccurrences(listOfCountries, "Romania");
        System.out.println("Romania count: " + occurrencesOfRomania);
        printElements(listOfCountries);
    }

    private static List<String> createListOfCountries() {
        // DONE: create a list of 5 countries
        List<String> countries = new ArrayList<>();

        // DONE: CREATE

        countries.add("Romania");   // 0
        countries.add("Italia");    // 1
        countries.add("Franta");    // 2
        countries.add("Germania");  // 3
        countries.add("Spania");
        countries.add("Romania");

        return countries;
    }

    private static void listOperations(List<String> countries) {
        // DONE: READ
        System.out.println(countries.get(1));
        System.out.println(countries.indexOf("Romania"));

        // DONE: UPDATE
        countries.set(2, "Russia");

        // DONE: DELETE
        String countryToDelete = "Italia";

        if (countries.contains(countryToDelete)) {
            countries.remove(countryToDelete);
        } else {
            throw new RuntimeException(countryToDelete + " is not in the list!");
        }

        System.out.println(countries.size());
        printElements(countries);
    }

    private static int countOccurrences(List<String> list, String countryName) {
        // DONE: count occurrences of particular country

        // iterate
        // if found > increment a number
        // return number

        int result = 0;

        // from, to, step
        for (int i = 0; i < list.size(); i += 1) {
            if (countryName.equals(list.get(i))) {
                result += 1;
            }
        }

        return result;
    }

    private static void printElements(List<String> list) {
        // DONE: print elements in a list
        for (Object element : list) {
            System.out.println(element);
        }
    }

}
