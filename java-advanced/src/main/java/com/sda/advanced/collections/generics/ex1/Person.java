package com.sda.advanced.collections.generics.ex1;

public class Person implements Comparable<Person> {

    private int height;

    public Person(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return this.height - otherPerson.height;
    }
}
