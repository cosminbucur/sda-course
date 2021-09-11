package com.bucur.fluent.ex1;

public class DemoFluentInterfaces {

    public static void main(String[] args) {
        new Arsalan()
            .name("ARSALAN")
            .show()
            .order(0)
            .order(1)
            .eat()
            .pay();
    }
}
