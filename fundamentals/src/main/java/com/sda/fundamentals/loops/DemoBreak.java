package com.sda.fundamentals.loops;

public class DemoBreak {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
            if (i == 2) {
                System.out.println("this is enough!");
                break;
            }
        }
    }
}
