package com.sda.fundamentals.wrappers;

public class RealWrapperClasses {

    public static void main(String[] args) {
        useCaseForWrappers();
    }

    private static void useCaseForWrappers() {
        // consent not selected
        Boolean consent = null;
        System.out.println("before consent: " + consent);

        consent = true;
        System.out.println("after consent: " + consent);

        // prevent confusion between
        Integer unknownTemperature = null;
        Integer negativeTemperature = -5;
        Integer temperature = 0;    // freezing threshold
        Integer positiveTemperature = 20;
    }
}
