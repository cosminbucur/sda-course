package com.sda.fundamentals.scanner;

import java.util.Scanner;

public class RealScanner {

    public static void main(String[] args) {
        // create scanner
        Scanner scanner = new Scanner(System.in);

        showMainMenu();

        int option = -1;

        while (option != 0) {
            // get user input
            option = scanner.nextInt();

            // act depending on input
            switch (option) {
                case 0:
                    System.out.println("bye!");
                    break;
                case 1:
                    giveMeCash();
                    break;
                case 2:
                    makeMePretty();
                    break;
                default:
                    System.out.println("select 1, 2 or 0");
                    break;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("Select an option: ");
        System.out.println("1. give me 5$!");
        System.out.println("2. make me pretty!");
        System.out.println("0. exit");
    }

    private static void giveMeCash() {
        System.out.println("here, 5$!");
        showMainMenu();
    }

    private static void makeMePretty() {
        System.out.println("you are pretty!");
        showMainMenu();
    }
}
