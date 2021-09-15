package com.sda.patterns.grasp.creator;

public class DemoCreator {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        System.out.println(factory.createShape("circle"));
        System.out.println(factory.createShape("rectangle"));
        System.out.println(factory.createShape("square"));
    }
}
