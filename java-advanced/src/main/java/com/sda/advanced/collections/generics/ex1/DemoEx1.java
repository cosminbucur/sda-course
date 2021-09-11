package com.sda.advanced.collections.generics.ex1;

/**
 * Create a Person class that will implement a Comparable interface. The Person class should
 * implement compareTo method, that will verify if one person is taller than another.
 */
public class DemoEx1 {

    public static void main(String[] args) {
        Person person1 = new Person(180);
        Person person2 = new Person(170);

        if (person1.compareTo(person2) > 0) {
            System.out.println("person1 is taller!");
        }
    }

}
