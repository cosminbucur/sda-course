package com.sda.advanced.concurrency.how;

class MyThread extends Thread {

    // initially setting the flag as true
    private volatile boolean flag = true;

    // this method will set flag as false
    public void stopRunning() {
        flag = false;
    }

    @Override
    public void run() {
        // print thread name
        System.out.println(Thread.currentThread().getName());

        // keep the task in while loop
        // this will make thread continue to run until flag becomes false
        while (flag) {
            System.out.println("I am running....");
        }

        System.out.println("Stopped Running....");
    }
}
