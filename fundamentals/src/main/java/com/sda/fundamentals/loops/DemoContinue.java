package com.sda.fundamentals.loops;

public class DemoContinue {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
            if (i == 2) {
                System.out.println("hey this is fun!");
                continue;
            }
        }
    }
}
