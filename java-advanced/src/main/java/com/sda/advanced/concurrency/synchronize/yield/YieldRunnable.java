package com.sda.advanced.concurrency.synchronize.yield;

public class YieldRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Current thread" + Thread.currentThread().getName() + " priority " + Thread.currentThread().getPriority() + " START");

        // give thread with equal priority chance to run
        Thread.yield();

        System.out.println("Current thread" + Thread.currentThread().getName() + " priority " + Thread.currentThread().getPriority() + " END");
    }
}
