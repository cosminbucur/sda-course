package com.sda.fundamentals.array;

public class DemoArray {

    public static void main(String[] args) {
        // create

        // empty array
        int[] emptyArray = {};
        System.out.println("length = " + emptyArray.length);

        int[] arrayWithInitialSize = new int[10];
        System.out.println("length = " + arrayWithInitialSize.length);

        int[] array = {1, 2, 3, 4, 5};

        // read
        int firstNumber = array[0];
        System.out.println(firstNumber);
        int lastNumber = array[array.length - 1];
        System.out.println(lastNumber);

        printArray(array);

        // update
        array[0] = 6;
        System.out.println(array[0]);

        printArraySmarter(array);
    }

    public static void printArray(int[] array) {
        System.out.println("just for:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArraySmarter(int[] array) {
        System.out.println("enhanced for:");

        // enhanced for
        // for (type item : collection)
        for (int item : array) {
            System.out.println(item);
        }
    }

}
