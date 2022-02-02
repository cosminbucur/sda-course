package com.sda.patterns.solid.open_closed2.before;

public class AreaCalculator {

    public Double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.length * rectangle.width;
    }

    // violates the open closed principle
    public Double calculateCircleArea(Circle circle) {
        return (22 / 7) * circle.radius * circle.radius;
    }
}

class Rectangle {

    public Double length;
    public Double width;
}

class Circle {

    public Double radius;
}
