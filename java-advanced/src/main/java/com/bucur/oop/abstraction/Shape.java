package com.bucur.oop.abstraction;

public abstract class Shape {

    String color;

    // abstract class can have constructor
    public Shape(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    // abstract methods
    abstract double area();

    public abstract String toString();

    // concrete method
    public String getColor() {
        return color;
    }
}
