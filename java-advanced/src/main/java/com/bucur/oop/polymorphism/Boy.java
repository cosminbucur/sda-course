package com.bucur.oop.polymorphism;

public class Boy extends Human {

    public static void walk() {
        System.out.println("Boy walks");
    }

    // can't override final method

    // is this overriding?
    private void sing() {
        System.out.println("Boy sings");
    }
}
