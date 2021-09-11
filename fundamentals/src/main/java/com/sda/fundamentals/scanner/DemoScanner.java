package com.sda.fundamentals.scanner;

import java.util.Scanner;

public class DemoScanner {

    public static void main(String[] args) {
        // create scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("your name?");
        String name = scanner.next();
        System.out.println("hi " + name);

        System.out.println("your id?");
        int id = scanner.nextInt();
        System.out.println(id + " confirmed");
    }
}

