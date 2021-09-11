package com.sda.advanced.exceptions.handlig;

public class DemoTryCatch {

    public static void main(String[] args) {
        tryCatch();

        multipleCatch();

        catchWithMultipleParams();
    }

    private static void tryCatch() {
        try {
            int x = 5 / 0;
        } catch (Exception e) {
            System.out.println("Exception is caught and handled!");
        } finally {
            System.out.println("This will be printed no matter what the value of y is");
        }
    }

    private static void multipleCatch() {
        int[] intArray = {8, 6, 4};
        int y = 0;
        try {
            int x = intArray[2] / y;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndex(...)Exception caught!");
        } catch (Exception e) {
            System.out.println("Another exception caught!");
        }
    }

    private static void catchWithMultipleParams() {
        int[] intArray = {8, 6, 4};
        int y = 0;
        try {
            int x = intArray[2] / y;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("ArithmeticException or a " +
                "ArrayIndexOutOfBoundsException caught!");
        }
    }
}
