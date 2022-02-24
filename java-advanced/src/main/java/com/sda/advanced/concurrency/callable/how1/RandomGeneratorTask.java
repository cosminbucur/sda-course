package com.sda.advanced.concurrency.callable.how1;

import java.util.Random;
import java.util.concurrent.Callable;

// callable is a runnable on steroids
public class RandomGeneratorTask implements Callable<Integer> {

    // you can throw exception (unlike runnable run())
    @Override
    public Integer call() throws Exception {
        // perform some computation
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        Thread.sleep(randomNumber * 1000L);

        // a callable can return a result
        return randomNumber;
    }
}
