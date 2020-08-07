package com.bucur.collections.list.ex2;

import java.util.ArrayList;
import java.util.List;

public class DemoEx2 {

    private static List ratings = new ArrayList();

    public static void main(String[] args) {
        Rating goodRating = new Rating(6);
        Rating averageRating = new Rating(3);
        Rating badRating = new Rating(1);

        ratings.add(goodRating);
        ratings.add(averageRating);
        ratings.add(badRating);

        System.out.println("average rating is: " + computeAverage());
    }

    private static double computeAverage() {
        int ratingSum = 0;
        int result = 0;

        // fail early
        if (ratings.isEmpty()) {
            return result;
        }

        // add ratings
        for (Object rating : ratings) {
            ratingSum += ((Rating) rating).getValue();
        }

        return ratingSum / ratings.size();
    }
}
