package com.sda.advanced.oop.encapsulation;

public class Printer {

    private String color;
    private int maxNumberOfPages;

    public Printer(String color, int maxNumberOfPages) {
        this.color = color;
        this.maxNumberOfPages = maxNumberOfPages;
    }

    // no getters and setters for full encapsulation

    public void print() {
        System.out.println("printing in progress");
    }
}

