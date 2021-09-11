package com.sda.advanced.collections.comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Movie> {

    // DONE: compare by name using Comparator
    @Override
    public int compare(Movie one, Movie two) {
        return one.getTitle().compareTo(two.getTitle());
    }
}
