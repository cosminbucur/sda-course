package com.sda.advanced.oop.inheritance;

public class DemoInheritance {

    public static void main(String[] args) {
        Car simpleCar = new Car();
        simpleCar.fillTank(100);

        Vehicle car = new Car();
        car.fillTank(50);
        car.drive();
    }
}
