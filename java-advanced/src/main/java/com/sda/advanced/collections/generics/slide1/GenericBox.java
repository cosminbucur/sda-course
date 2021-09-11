package com.sda.advanced.collections.generics.slide1;

// generic class that accepts any type of object
public class GenericBox<T> {

    private T item;

    // set item in constructor
    public GenericBox(T item) {
        this.item = item;
    }

    // set item by custom method
    public void add(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    // set item by setter
    public void setItem(T item) {
        this.item = item;
    }
}
