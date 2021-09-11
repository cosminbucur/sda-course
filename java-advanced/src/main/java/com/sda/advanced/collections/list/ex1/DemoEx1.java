package com.sda.advanced.collections.list.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoEx1 {

    static List<String> purchases = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("What item do you wish to purchase? ");
        String input = scanner.nextLine();

        while (input != "quit") {
            addItem(input);
        }
    }

    private static void addItem(String input) {
        if (purchases.contains(input)) {
            System.out.println(input + " is already in the list. try something else");
        } else {
            purchases.add(input);
            System.out.print("What else do you wish to purchase? ");
        }
    }

    private static void deleteItem(String input) {
        if (purchases.contains(input)) {
            purchases.remove(input);
        } else {
            System.out.println(input + " is not on the list");
        }
    }

    private static void displayItemsWithM(String input) {
        if (input.equals("m")) {
            System.out.println();
        }
    }
}
