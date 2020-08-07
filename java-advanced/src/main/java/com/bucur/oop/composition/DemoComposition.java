package com.bucur.oop.composition;

public class DemoComposition {

    public static void main(String[] args) {
        Car car = new Car(new Engine(), new Wheel());
        car.drive();
    }
}
