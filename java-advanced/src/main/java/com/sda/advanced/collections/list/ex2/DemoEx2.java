package com.sda.advanced.collections.list.ex2;

import java.util.ArrayList;
import java.util.List;

public class DemoEx2 {

    public static void main(String[] args) {
        List<Rating> ratings = new ArrayList<>();
        Rating goodRating = new Rating(6);
        Rating averageRating = new Rating(3);
        Rating badRating = new Rating(1);

        ratings.add(goodRating);
        ratings.add(averageRating);
        ratings.add(badRating);

        System.out.println("average rating is: " + computeAverage(ratings));
    }

    private static double computeAverage(List<Rating> ratings) {
        // fail early
        if (ratings.isEmpty()) {
            throw new RatingException("ratings can't be empty");
        }

        int ratingSum = 0;

        // add ratings
        for (Rating rating : ratings) {
            ratingSum += rating.getValue();
        }

        return ratingSum / (double) ratings.size();
    }
}
