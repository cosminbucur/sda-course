package com.sda.advanced.oop.composition;

public class Car {

    // has-a relationship
    private Engine engine;
    private Wheel wheel;

    public Car(Engine engine, Wheel wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }

    public void drive() {
        System.out.println("driving");
    }
}

class Engine {
}

class Wheel {
}