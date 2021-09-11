package com.sda.fundamentals.packages;

// import statement

import com.sda.fundamentals.packages.large.House;
import com.sda.fundamentals.packages.small.Car;

public class DemoPackages {

    public static void main(String[] args) {
        House house = new House();

        Car car = new Car();
        com.sda.fundamentals.packages.large.Car otherCar = new com.sda.fundamentals.packages.large.Car();
    }
}
