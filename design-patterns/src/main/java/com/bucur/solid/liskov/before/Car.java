package com.bucur.solid.liskov.before;

public class Car extends TransportationDevice {

    @Override
    void startEngine() {
        System.out.println("car starting engine");
    }
}
