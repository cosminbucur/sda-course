package com.sda.advanced.optional.test;

// https://dzone.com/articles/using-optional-correctly-is-not-optional
public class DemoOptional {

    public static void main(String[] args) {
        WrongOptional optional = new WrongOptional();
        optional.correctUsageOfGet();
    }

}
