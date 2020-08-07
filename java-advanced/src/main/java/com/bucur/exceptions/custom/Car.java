package com.bucur.exceptions.custom;

public class Car {

    private int speed;

    // when a threshold is reached throw exception
    public void increaseSpeed() throws CarCrashedException {
        this.speed += 70;
        if (this.speed > 200) {
            throw new CarCrashedException(this);
        }
    }
}
