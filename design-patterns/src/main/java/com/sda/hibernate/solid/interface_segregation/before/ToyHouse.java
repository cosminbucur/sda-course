package com.bucur.solid.interface_segregation.before;

public class ToyHouse implements Toy {

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
    }

    @Override
    public void fly() {
    }
}
