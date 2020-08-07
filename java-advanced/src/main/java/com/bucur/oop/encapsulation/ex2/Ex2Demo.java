package com.bucur.oop.encapsulation.ex2;

public class Ex2Demo {

    public static void main(String[] args) {
        Pocket pocket = new Pocket();
        System.out.println("Attempt to set -5...");
        pocket.setMoney(-5);

        System.out.println("Attempt to set 5000...");
        pocket.setMoney(5000);

        System.out.println("Attempt to set 3000...");
        pocket.setMoney(3000);

        System.out.println("Attempt to get 8 bucks from the pocket.  Actually I get: " + pocket.getMoney(8));

        System.out.println("Attempt to get 2000 bucks from the pocket.  Now we're talking: " + pocket.getMoney(2000));
    }
}
