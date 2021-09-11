package com.bucur.solid.liskov.after;

public class Car extends DeviceWithEngine {

    @Override
    void startEngine() {
        System.out.println("car starting engine");
    }
}
