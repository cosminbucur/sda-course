package com.bucur.ex10;

public class Director extends Employee {

    private PointingFinger pointingFinger;

    @Override
    void work() {
        pointingFinger.use();
    }
}
