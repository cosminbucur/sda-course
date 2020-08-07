package com.bucur.ex10;

public class Manager extends Employee {

    private Laptop laptop;

    @Override
    void work() {
        laptop.use();
    }
}
