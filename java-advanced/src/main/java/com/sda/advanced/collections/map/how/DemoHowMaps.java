package com.sda.advanced.collections.map.how;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DemoHowMaps {

    public static void main(String[] args) {
        compareMaps();

        Map<String, String> countries = initializeMapWithCountries();
        printMap(countries);

        String capitalOfPoland = countries.get("Poland");
        System.out.println(capitalOfPoland);

        // remove country
        countries.remove("Poland");
        System.out.println(capitalOfPoland);

        // check size
        countries.size();

        // print the list of values
        System.out.println(countries.values());

        // print the set of keys
        System.out.println(countries.keySet());

    }

    private static Map<String, String> initializeMapWithCountries() {
        // create map of string (key) - string (value)
        Map<String, String> countries = new HashMap<>();

        // add entries to map
        countries.put("Poland", "Warsaw");
        countries.put("Germany", "Berlin");
        countries.put("poland", "warsaw");
        return countries;
    }

    // print map elements
    private static void printMap(Map<String, String> map) {

        // iterate map ( for each entry in the set of entries)
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String country = entry.getKey();
            String capital = entry.getValue();
            System.out.printf("%s : %s\n", country, capital);
        }
    }

    private static void compareMaps() {
        Map<String, String> hashMap = new TreeMap<>();
        hashMap.put("Poland", "Warsaw");
        hashMap.put("Germany", "Berlin");
        printMap(hashMap);

        System.out.println("-----------");

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("Poland", "Warsaw");
        treeMap.put("Germany", "Berlin");
        printMap(treeMap);
    }

    public static void addToList(List<String> list, String string) {
        list.add(string);
    }
}
