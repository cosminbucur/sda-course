package com.bucur.patterns.creational.prototype;

public abstract class Shape {

    private int x;
    private int y;
    private String color;

    public Shape() {
    }

    public Shape(Shape source) {
        if (source != null) {
            this.x = source.x;
            this.y = source.y;
            this.color = source.color;
        }
    }

    abstract Shape cloneShape();
}
