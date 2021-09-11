package com.sda.fundamentals.project;

import java.util.Scanner;

// TODO: ignore
public class Project1 {

    public static final String SELECT_AN_OPTION = "Select an option.";

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // create a CLI for an eshop without using objects
        showMainMenu();
    }

    private static void showMainMenu() {
        System.out.println("Welcome!");
        System.out.println(SELECT_AN_OPTION);
        System.out.println("1. Product catalog");
        System.out.println("2. My orders");
        System.out.println("0. EXIT");

        int option = scanner.nextInt();

        switch (option) {
            case 0: {
                System.out.println("thanks for the visit. bye!");
                break;
            }
            case 1: {
                showProducts();
                break;
            }
            case 2: {
                showMyOrders();
                break;
            }
            default: {
                showMainMenu();
                break;
            }
        }

    }

    private static void showProducts() {
        String[] products = {"1. phone", "2. tv", "3. camera"};

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }

        System.out.println("Select products by inserting the ID and pressing ENTER");
        System.out.println("When ready to place the order, select 0.");

        int option = -1;
        while (option != 0) {
            option = scanner.nextInt();

            if (option != 0) {
                String selectedProduct = getProductName(products[option]);
            }
        }

        showMainMenu();
    }

    private static void showMyOrders() {

    }

    private static String getProductName(String product) {
        return product.substring(2);
    }
}
