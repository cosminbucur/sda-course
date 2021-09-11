package com.sda.advanced.oop.inheritance;

// is-a relationship
public class Car extends Vehicle {

    @Override
    public int fillTank(int amount) {
        return super.tankCapacity + amount;
    }
}