package com.sda.fundamentals.conditionals;

public class DemoSwitch {

    public static void main(String[] args) {
        // can use string
        int option = 2;

        switch (option) {
            case 1:
                System.out.println("fast food menu");
                break;
            case 2:
                System.out.println("regular menu");
                break;
            case 3:
                System.out.println("vegan menu");
                break;
            default:
                System.out.println("unknown option");
        }
    }
}
