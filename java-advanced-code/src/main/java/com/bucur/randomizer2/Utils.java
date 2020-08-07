package com.bucur.randomizer2;

import java.util.Random;

public class Utils {

    // a utility method should perform reusable operations
    public static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1 + min);
    }
}
