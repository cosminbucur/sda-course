package com.sda.advanced.collections.set.ex1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DemoEx1 {

    public static Set<String> colors = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            dispatch(scanner, option);
        }
    }

    private static void dispatch(Scanner scanner, int option) {
        while (option != 0) {
            switch (option) {
                case 1:
                    addColor();
                    break;
                case 2:
                    printColors(colors);
                    break;
                case 3:
                    deleteColor();
                    break;
                default:
                    System.out.println("Choose one of the displayed options!");
            }
            displayMenu();
            option = scanner.nextInt();
        }
    }

    private static void addColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert a color: ");
        String color = scanner.nextLine();

        colors.add(color);
        System.out.println("color " + color + " added to set");
        printColors(colors);
    }

    private static void printColors(Set<String> colors) {
        System.out.print("colors in set: ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
    }

    private static void deleteColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("delete a color: ");
        String color = scanner.nextLine();

        if (colors.contains(color)) {
            colors.remove(color);
            System.out.println("color " + color + " removed from the set");
        } else {
            throw new IllegalArgumentException("color " + color + " is not in the set");
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu -----------------");
        System.out.println("1. add color");
        System.out.println("2. print colors in set");
        System.out.println("3. remove color");
        System.out.println("0. exit \n");
        System.out.println("Please choose an option:");
    }

}
