package com.sda.advanced.concurrency.synchronize.ex2;

public class SynchronizedCounter {

    private int count = 0;

    // Synchronized Method
    public synchronized void increment() {
        // obtain lock
        count = count + 1;
    }
    // release lock

    public int getCount() {
        return count;
    }
}
