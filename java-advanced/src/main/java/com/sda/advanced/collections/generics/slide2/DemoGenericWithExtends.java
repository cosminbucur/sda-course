package com.sda.advanced.collections.generics.slide2;

public class DemoGenericWithExtends {

    public static void main(String[] args) {
        // create objects to store in generic class
        Bike bike = new Bike();
        Vehicle otherBike = new Bike();

        // create generic class with a specific type (bike)
        Garage<Vehicle> garage = new Garage(bike);

        // add vehicle to garage
        Garage<Vehicle> garage2 = new Garage(otherBike);

        // add wrong type (not vehicle or vehicle child)
//        Garage<Vehicle> garage3 = new Garage("some string");
    }
}

