package com.sda.patterns.design.creational.prototype;

public class Circle extends Shape {

    public int radius;

    public Circle() {
    }

    public Circle(Circle source) {
        super(source);
        if (source != null) {
            this.radius = source.radius;
        }
    }

    @Override
    Shape cloneShape() {
        return new Circle(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
            "radius=" + radius +
            '}';
    }
}
