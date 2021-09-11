package com.sda.advanced.collections.comparator;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    // DONE: compare by rating descending using Comparator
    @Override
    public int compare(Movie one, Movie two) {
        return Integer.compare(two.getRating(), one.getRating());
    }

    public int compareLongVersion(Movie fifth, Movie two) {
        if (fifth.getRating() < two.getRating()) return -1;
        if (fifth.getRating() > two.getRating()) return 1;
        else return 0;
    }
}