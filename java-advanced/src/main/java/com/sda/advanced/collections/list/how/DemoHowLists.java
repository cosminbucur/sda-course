package com.sda.advanced.collections.list.how;

import com.sda.advanced.collections.CollectionPrinter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoHowLists {

    public static void main(String[] args) {
        // create a list
        List<String> countries = new ArrayList<>();

        CollectionPrinter.printList(countries);

        // CREATE

        // add items
        countries.add("england");
        countries.add("spain");
        countries.add("italy");
        countries.add("china");
        countries.add("korea");
        countries.add("england");

        // READ

        // iterate using list iterator
        Iterator<String> iterator = countries.iterator();

        // print countries with iterator
        while (iterator.hasNext()) {
            String nextCountry = iterator.next();
            System.out.println(nextCountry + " " + nextCountry.toUpperCase());
        }

        // print the 2nd item in the list
        String spain = countries.get(1);
        System.out.println(spain);

        // print the index of "italy"
        System.out.println("index of italy: " + countries.indexOf("italy"));

        // UPDATE

        // change the country at index
        countries.add(0, "");

        System.out.println("before remove: ");
        CollectionPrinter.printList(countries);

        // DELETE

        // remove 1 item and print the list
        countries.remove("korea");
        System.out.println("\nafter remove : ");
        CollectionPrinter.printList(countries);

        // OTHER

        // print the list size
        System.out.println("number of countries: " + countries.size());

        // if spain exist, then print "ola"
        if (countries.contains("spain")) {
            System.out.println("\nola");
        }

        // check if it's not empty and print
        if (!countries.isEmpty()) {
            System.out.println();
        }
    }
}



