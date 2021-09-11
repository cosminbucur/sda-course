package com.sda.advanced.exceptions.custom.unchecked;

public class CarCrashedException extends RuntimeException {

    public CarCrashedException(Car car) {
        // calling Exception(String message) constructor
        super("Car " + car + " has crashed at speed " + car.getSpeed());
    }
}
