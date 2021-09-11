package com.sda.advanced.collections.generics.slide2;

// generic class that accepts only an object of type Vehicle or any child of Vehicle
public class Garage<T extends Vehicle> {

    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }
}
