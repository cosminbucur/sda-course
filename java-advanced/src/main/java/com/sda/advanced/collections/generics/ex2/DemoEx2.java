package com.sda.advanced.collections.generics.ex2;

/**
 * Create a simple Generic class , that will give a possibility , to store any kind of value
 * within. Add object of type String, Integer and Double to array of that Generic type.
 * Print all values of the array within a loop.
 */
public class DemoEx2 {

    public static void main(String[] args) {
        Object[] items = {"hello", 2, 5.3};
        Bag<Object> bag = new Bag<>(items);
        bag.printItems();
    }
}
