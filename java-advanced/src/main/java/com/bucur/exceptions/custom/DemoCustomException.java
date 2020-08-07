package com.bucur.exceptions.custom;

public class DemoCustomException {

    public static void main(String[] args) throws CarCrashedException {
        Car car = new Car();

        car.increaseSpeed();    // 0 to 70
        car.increaseSpeed();    // 70 to 140
        car.increaseSpeed();    // 140 to 210 RIP
    }
}
