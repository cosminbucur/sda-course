package com.sda.patterns.design.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class DemoPrototypePattern {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle();
        circle.radius = 15;
        shapes.add(circle);

        Shape anotherCircle = circle.cloneShape();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        shapes.add(rectangle);

        System.out.println(shapes);
    }
}
