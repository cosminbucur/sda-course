package com.sda.fundamentals.operators;

public class DemoArithmeticOperators {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        int addition = a + b;           // 15
        System.out.println(addition);

        int subtraction = a - b;        // -5
        System.out.println(subtraction);

        int multiplication = a * b;      // 50
        System.out.println(multiplication);

        int division = b / a;            // 2
        System.out.println(division);

        // modulo (rest after division)
        int modulo = 5 % 2;
        System.out.println(modulo);      // 1


        // post increment
        int age = 20;
        System.out.println(age++);          // 20

        // pre increment
        int size = 20;
        System.out.println(++size);         // 21

        // post decrement
        int temperature = 5;
        System.out.println(temperature--);  // 5

        int count = 5;
        System.out.println(--count);        // 4
    }
}
