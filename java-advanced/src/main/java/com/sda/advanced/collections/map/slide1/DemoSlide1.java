package com.sda.advanced.collections.map.slide1;

import java.util.HashMap;
import java.util.Map;

public class DemoSlide1 {

    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put(" Poland", "Warsaw");
        countries.put(" Germany", "Berlin");

        // iterate using entry
        for (Map.Entry<String, String> dictionary : countries.entrySet()) {
            String country = dictionary.getKey();
            String capital = dictionary.getValue();
            System.out.printf("%s : %s \n ", country, capital);
        }
    }
}
