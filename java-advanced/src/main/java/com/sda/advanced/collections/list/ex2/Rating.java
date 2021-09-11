package com.sda.advanced.collections.list.ex2;

public class Rating {

    int value;

    public Rating(int value) {
        if (value < 1 || value > 6) {
            throw new RatingException("rating must be between 1 and 6");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
