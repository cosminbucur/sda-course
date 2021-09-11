package com.sda.advanced.oop.abstraction;

public class DemoAbstraction {

    public static void main(String[] args) {
        Shape shape1 = new Square("Red", 2);
        Shape shape2 = new Rectangle("Yellow", 2, 4);

        System.out.println(shape1.toString());
        System.out.println(shape2.toString());
    }
}
