package com.bucur.grasp.creator;

public class ShapeFactory {

    public Shape createShape(String shape) {
        if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else {
            return new Square();
        }
    }
}
