package com.sda.advanced.concurrency.synchronize;

// https://howtodoinjava.com/java/multi-threading/wait-notify-and-notifyall-methods/
public class DemoMethodSynchronized {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new CounterThread(counter);
        Thread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();
    }
}
