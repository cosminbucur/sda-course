package com.bucur.solid.interface_segregation.after;

public class ToyCar implements Toy, Movable {

    double price;
    String color;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("ToyCar: Start moving car.");
    }

    @Override
    public String toString() {
        return "ToyCar: Movable Toy car- Price: " + price + " Color: " + color;
    }
}
