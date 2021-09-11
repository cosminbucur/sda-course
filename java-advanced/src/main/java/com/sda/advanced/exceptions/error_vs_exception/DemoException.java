package com.sda.advanced.exceptions.error_vs_exception;

public class DemoException {

    public static void main(String[] args) {
        int a = 5, b = 0;

        // Attempting to divide by zero
        try {
            int c = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
