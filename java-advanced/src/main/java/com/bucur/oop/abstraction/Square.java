package com.bucur.oop.abstraction;

public class Square extends Shape {

    double length;

    public Square(String color, double length) {
        // calling Shape constructor
        super(color);
        System.out.println("Square constructor called");
        this.length = length;
    }

    @Override
    double area() {
        return Math.pow(length, 2);
    }

    @Override
    public String toString() {
        return "Square color is " + super.color +
            "and area is : " + area();
    }
}
