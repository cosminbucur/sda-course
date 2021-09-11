package com.sda.fundamentals.strings;

public class DemoStrings {

    public static void main(String[] args) {
        String title = "Game of thrones";

        // equality check
        String otherTitle = "Game of thrones";

        // compare values
        System.out.println(title.equals(otherTitle));   // true

        // compare references
        System.out.println(title == otherTitle);    // false
    }
}
