package com.sda.fundamentals.wrappers;

public class DemoWrapperClasses {

    // boolean, byte, short, char, int, long, float, double
    // Boolean, Byte, Short, Character, Integer, Long, Float, Double
    public static void main(String[] args) {
        convertPrimitiveToWrapperClass();
        boxingAndUnboxing();
    }

    public static void convertPrimitiveToWrapperClass() {
        // convert from primitive
        Integer integerObject = Integer.valueOf(100);
        System.out.println(integerObject);

        // convert from stream
        Double doubleObject = Double.valueOf("10.8");
        System.out.println(doubleObject);
    }

    public static void boxingAndUnboxing() {
        // boxing
        int integer = 30;
        Integer boxedInteger = Integer.valueOf(integer);
        System.out.println(boxedInteger);

        // unboxing
        Double boxedDouble = 20.5;
        double unboxedDouble = boxedDouble;
        System.out.println(unboxedDouble);
    }
}
