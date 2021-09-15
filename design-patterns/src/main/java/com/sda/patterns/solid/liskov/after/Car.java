package com.sda.patterns.solid.liskov.after;

public class Car extends DeviceWithEngine {

    @Override
    void startEngine() {
        System.out.println("car starting engine");
    }
}
