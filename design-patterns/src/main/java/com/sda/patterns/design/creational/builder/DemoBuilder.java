package com.sda.patterns.design.creational.builder;

import com.sda.patterns.design.creational.builder.builders.CarBuilder;
import com.sda.patterns.design.creational.builder.builders.CarManualBuilder;
import com.sda.patterns.design.creational.builder.cars.Car;
import com.sda.patterns.design.creational.builder.director.Director;
import com.sda.patterns.design.creational.builder.manuals.Manual;

public class DemoBuilder {

    public static void main(String[] args) {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
