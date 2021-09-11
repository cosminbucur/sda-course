package com.sda.fundamentals.conditionals;

public class DemoIfElse {

    public static void main(String[] args) {
        // if else
        int account = 1000;
        if (account > 100_000_000) {
            System.out.println("you are mason!");
        } else {
            System.out.println("you are pawn");
        }

        // multiple if statements
        int age = 19;

        if (age >= 67) {
            System.out.println("you are rich!");
        } else if (age >= 18) {
            System.out.println("get a job, get married");
        } else {
            System.out.println("go to school");
        }

        // ternary operator
        // statement ? if yes : if false
        String response = age >= 18 ? "adult" : "minor";
        System.out.println(response);

        int price = age >= 18 ? 200 : 100;
        System.out.println(price);
    }
}
