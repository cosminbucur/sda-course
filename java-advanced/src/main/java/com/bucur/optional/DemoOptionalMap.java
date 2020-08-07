package com.bucur.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DemoOptionalMap {

    public static void main(String[] args) {

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(s -> s.toUpperCase()));
        System.out.println("Empty Optional    :: " + emptyGender.map(s -> s.toUpperCase()));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

        List<String> names = Arrays.asList("one", "two");
        names.stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException());
    }
}
