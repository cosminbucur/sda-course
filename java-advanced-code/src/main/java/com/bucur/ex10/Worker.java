package com.bucur.ex10;

public class Worker extends Employee {

    private Hammer hammer;

    @Override
    void work() {
        hammer.use();
    }
}
