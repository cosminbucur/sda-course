package com.sda.testing.tdd.interval;

public enum Frequency {

    DAILY("DAILY"),
    MONTHLY("MONTHLY");

    private final String value;

    Frequency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
