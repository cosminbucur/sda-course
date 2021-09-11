package com.sda.fundamentals.objects;

public class Car {

    // fields
    private String color;
    private int maxSpeed;
    private String brand;

    // real methods
    public void drive() {
        System.out.println("driving");
    }

    public void stop() {
        System.out.println("breaking");
    }

    public void printCarParameters() {
        System.out.printf("Car color is: %s, max speed is: %d, car brand is: %s%n", color, maxSpeed, brand);
    }

    // state methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
