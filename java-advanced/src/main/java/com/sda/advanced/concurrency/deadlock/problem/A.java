package com.sda.advanced.concurrency.deadlock.problem;

// Resource A
public class A {
    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}