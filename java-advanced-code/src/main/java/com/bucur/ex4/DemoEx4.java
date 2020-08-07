package com.bucur.ex4;

import java.util.Scanner;

public class DemoEx4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("insert person details: firstName LastName birthday (MM/dd/yyyy)");
            System.out.println("(or press q to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            Parser parser = new Parser();
            parser.parseInput(input);
        }


    }
}
