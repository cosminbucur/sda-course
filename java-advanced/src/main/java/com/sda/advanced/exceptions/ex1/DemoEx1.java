package com.sda.advanced.exceptions.ex1;

import java.util.Scanner;

public class DemoEx1 {

    // TODO: exceptions
    // 1. Create a single shared Scanner object for keyboard input.
    //    This must be done in only one class of your program.
    //    All keyboard input must be handled through that one class.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 2. Don't forget to prompt the user
        System.out.print("Type some data for the program: ");

        // 3. Use the Scanner to read a line of text from the user.
        String input = scanner.nextLine();

        // 4. Now, you can do anything with the input string that you need to.
        // Like, output it to the user.
//        System.out.println( "input = " + input );
        evaluateStatus(input);
    }

    private static void evaluateStatus(String input) {
        int intInput;
        double doubleInput;

        try {
            intInput = Integer.parseInt(input);
            System.out.println("output: " + intInput);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            doubleInput = Double.parseDouble(input);
            System.out.println("output: " + doubleInput);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
