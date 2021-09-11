package com.sda.advanced.collections.comparable;

public class Car implements Comparable<Car> {

    private int fabricationYear;

    public Car(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.fabricationYear - otherCar.fabricationYear;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }
}
