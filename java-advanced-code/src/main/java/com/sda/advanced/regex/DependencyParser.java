package com.sda.advanced.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://farenda.com/java/java-8-regex-match-group-named-capturing-groups/
public class DependencyParser {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Paste the dependency here: ");
        String input = scanner.nextLine();
        System.out.println(parseStuff(input));
    }

    public static String parseStuff(String input) {
        String regex = "compile group: '(\\S*)', name: '(\\S*)', version: '(\\S*)'";
        Pattern dependencyPattern = Pattern.compile(regex);
        Matcher dependencyDetails = dependencyPattern.matcher(input);

        dependencyDetails.find();

        System.out.println(dependencyDetails.group(1));
        System.out.println(dependencyDetails.group(2));
        System.out.println(dependencyDetails.group(3));

        StringBuilder result = new StringBuilder();
        result.append("implementation ")
            .append("'")
            .append(dependencyDetails.group(1))
            .append(":")
            .append(dependencyDetails.group(2))
            .append(":")
            .append(dependencyDetails.group(3))
            .append("'");

        return result.toString();
    }
}
