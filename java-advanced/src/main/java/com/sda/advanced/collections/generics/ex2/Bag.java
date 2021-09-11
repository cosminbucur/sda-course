package com.sda.advanced.collections.generics.ex2;

public class Bag<T> {

    private T[] items;

    public Bag(T[] items) {
        this.items = items;
    }

    public void printItems() {
        for (T item : items) {
            System.out.println("item: " + item);
        }
    }
}
