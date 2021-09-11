package com.sda.advanced.exceptions.custom.unchecked;

public class Car {

    private int speed;

    // when a threshold is reached throw exception
    public void increaseSpeed() {
        this.speed += 70;
        if (this.speed > 200) {
            throw new CarCrashedException(this);
        }
    }

    public int getSpeed() {
        return speed;
    }
}
