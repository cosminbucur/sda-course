package com.sda.fundamentals.loops;

public class DemoDoWhileLoops {

    public static void main(String[] args) {
        // when you don't know the number of loops

        int i = 0;

        // execute this and repeat until condition is met
        do {
            System.out.println("i = " + i);
            i++;
        }
        while (i <= 5);
    }
}
