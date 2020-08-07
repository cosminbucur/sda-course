package com.bucur.ex3;

import com.bucur.ex4.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://regex101.com/
public class Parser {

    // paul ene 23/09/1990
    public Person parseInput(String input) {
        Pattern personPattern = Pattern.compile("(\\w+),(\\w+),(\\d{1,2}/\\d{1,2}/\\d{4})");
        Matcher matcher = personPattern.matcher(input);
        Person person = new Person();

        if (matcher.find()) {
            if (
                matcher.group(1) == null ||
                    matcher.group(2) == null ||
                    matcher.group(3) == null
            ) {
                person.setFirstName(matcher.group(1));
                person.setLastName(matcher.group(2));
                person.setBirthday(parseDate(matcher.group(3)));
                System.out.println(person);
                return person;
            } else {
                System.out.println("invalid input");
            }
        }
        return null;
    }

    private LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
