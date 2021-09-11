package com.sda.advanced.concurrency.callable.how2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoFutureAndCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // executor service - interface
        // executors - utility class (factory) used to create executors

        // single thread executor is ideal for creating an event loop
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            // Perform some computation
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        // submits the task for execution by a thread
        // it doesn't know when the result will be ready
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");

        // future - class used to fetch the result of the task when it's available
        // Future.get() blocks until the result is available
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }

    private static void callableInAction() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        String result = future.get();
    }
}
