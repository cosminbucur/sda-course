package com.bucur.oop.inheritance;

public abstract class Vehicle {

    protected int tankCapacity;

    // abstract method - must be implemented by children
    public abstract int fillTank(int amount);

    // regular method - can be overloaded or overridden
    public void drive() {
        System.out.println("just driving");
    }

}
