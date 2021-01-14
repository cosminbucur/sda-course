package com.bucur.functional.interfaces.suppliers;

import java.util.Random;
import java.util.function.Supplier;

/**
 * The Supplier functional interface is a Function specialization that does not
 * take any arguments. It is typically used for lazy generation of values.
 * This can be useful if the generation of this argument takes a considerable amount of time
 */

// https://mkyong.com/java8/java-8-supplier-examples/
public class DemoSupplier {

    public static void main(String[] args) {
        getSquaredLazy();

        generateRandomNumber();
    }

    private static void getSquaredLazy() {
        Supplier<Double> lazyValue = () -> {
            try {
                // simulate a long and complex operation
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 9d;
        };

        Double valueSquared = squareLazy(lazyValue);
        System.out.println(valueSquared);
    }

    private static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }

    private static void generateRandomNumber() {
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt();
        int randomNumber = randomNumberSupplier.get();
        System.out.println(randomNumber);
    }
}
