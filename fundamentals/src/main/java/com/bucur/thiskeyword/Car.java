package com.bucur.thiskeyword;

public class Car {

    // static is the same for all instances
    public static final int numberOfWheels = 4;

    // this points to instance
    String brand;   // porche   // audi
    int speed;      // 200      // 150

    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public Car() {
        this.brand = "new brand";
        this.speed = 20;
    }
}
