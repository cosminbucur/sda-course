package com.sda.advanced.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparator {

    public static void main(String[] args) {

        // DONE: create a list of 3 movies
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("movie2", 2, 1987));
        list.add(new Movie("movie1", 1, 1977));
        list.add(new Movie("movie3", 3, 1998));

        // DONE: sort list by rating
        System.out.println("Sorted by rating descending");
        Collections.sort(list, new RatingComparator());
        list.forEach(movie -> System.out.println(movie.getTitle() + " " + movie.getRating()));

        // DONE: sort list by name
        System.out.println("Sorted by title ascending");
        Collections.sort(list, new NameComparator());
        System.out.println(list);
        list.forEach(movie -> System.out.println(movie.getTitle()));
    }
}
