package com.sda.advanced.optional.test;

import java.util.Optional;

public class WrongOptional {

    public void correctUsageOfGet() {
        Optional<String> myString = Optional.ofNullable(nullableString());
        if (myString.isPresent()) {
            doSomething(myString.get());
        }
    }

    private String nullableString() {
        return null;
    }

    private void doSomething(String string) {
        System.out.println(string);
    }
}
