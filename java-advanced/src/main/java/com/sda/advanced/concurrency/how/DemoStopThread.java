package com.sda.advanced.concurrency.how;

public class DemoStopThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // this will stop the thread
        thread.stopRunning();
    }

}
