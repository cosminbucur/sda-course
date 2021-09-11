package com.bucur.solid.liskov.before;

public class Bicycle extends TransportationDevice {

    @Override
    void startEngine() {
        throw new IllegalArgumentException("can not be implemented");
    }
}
