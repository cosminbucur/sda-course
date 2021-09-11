package com.sda.fundamentals.objects.initialization;

public class Spike {

    // static stuff
    private static int staticInt = 1;

    static {
        System.out.println("1st static init");
    }

    // constructor

    static {
        System.out.println("2nd static init");
    }

    // instance stuff
    private String name = "Alex";

    {
        System.out.println("1st instance init");
    }

    {
        System.out.println("2nd instance init");
    }

    Spike() {
        System.out.println("No  argument constructor");
    }

    Spike(int x) {
        System.out.println("ONE argument constructor");
    }
}
