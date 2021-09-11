package com.sda.advanced.functional.interfaces.consumers;

import java.util.Arrays;
import java.util.List;

/**
 * Consumer accepts a generified argument and returns nothing. It is a function that is
 * representing side effects
 */
public class DemoConsumers {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}
