package com.sda.fundamentals.methods;

public class DemoMethods {

    public static void main(String[] args) {
        printAHardCodedName();

        printAnyName("alex");

        // save result in variable
        int returnedResult = sum(2, 3);
        System.out.println(returnedResult);
    }

    // void method
    public static void printAHardCodedName() {
        System.out.println("cosmin");
    }

    // pass a parameter
    public static void printAnyName(String name) {
        System.out.println(name);
    }

    // return method
    public static int sum(int first, int second) {
        int result = first + second;
        return result;
    }
}
