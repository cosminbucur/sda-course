package com.sda.patterns.solid.open_closed2.after;

public class AreaCalculator {

    public Double calculateShapeArea(Shape shape) {
        return shape.calculateArea();
    }
}

interface Shape {
    Double calculateArea();
}

class Rectangle implements Shape {

    public Double length;
    public Double width;

    @Override
    public Double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {

    public Double radius;

    @Override
    public Double calculateArea() {
        return (22 / 7) * radius * radius;
    }
}




