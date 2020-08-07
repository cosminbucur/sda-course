package com.bucur.oop.encapsulation.ex2;

public class Pocket {

    private int money;

    public int getMoney(int money) {
        if (money <= 10) {
            return 0;
        } else {
            return money;
        }
    }

    public void setMoney(int money) {
        if (0 > money) {
            System.out.println("I'm already broke man!");
        }

        if (money <= 3000) {
            this.money = money;
            System.out.println(money + " is fine I guess...");
        }

        if (money > 3000) {
            System.out.println("I'm loaded!");
        }
    }
}
