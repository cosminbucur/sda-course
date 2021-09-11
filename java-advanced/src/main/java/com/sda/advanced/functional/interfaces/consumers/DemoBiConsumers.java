package com.sda.advanced.functional.interfaces.consumers;

import java.util.HashMap;
import java.util.Map;

/**
 * BiConsumer interface. One of its use cases is iterating through the entries of a map
 */
public class DemoBiConsumers {

    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
}
