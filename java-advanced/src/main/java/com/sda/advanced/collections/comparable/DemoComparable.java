package com.sda.advanced.collections.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort a list of 3 cars using comparable.
 */
public class DemoComparable {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car audi = new Car(2018);
        Car bugatti = new Car(2019);
        Car bmw = new Car(2017);

        cars.add(audi);
        cars.add(bugatti);
        cars.add(bmw);

        // DONE: sort list by fabrication year
        System.out.println("Sorted by fabrication year");
        Collections.sort(cars);
        cars.forEach(car -> System.out.println(car.getFabricationYear()));

        compareTwoObjects();
    }

    private static void compareTwoObjects() {
        Car audi = new Car(2018);
        Car bugatti = new Car(2019);

        if (audi.compareTo(bugatti) > 0) {
            System.out.println("audi is older than bugatti");
        }
    }
}
