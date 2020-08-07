package com.bucur.patterns.creational.singleton.naive_singleton_threads;

// class can not be extended
public final class Singleton {

    // single instance
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        // Following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
