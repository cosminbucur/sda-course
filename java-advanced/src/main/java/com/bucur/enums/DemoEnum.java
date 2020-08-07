package com.bucur.enums;

import java.util.Arrays;
import java.util.List;

public class DemoEnum {

    public static void main(String[] args) {
        Hero archer = new Hero(500, Role.ARCHER);
        Hero fighter = new Hero(800, Role.FIGHTER);

        // print all values in enum
        archer.getRole().printEnum();

        System.out.println(archer.getRole().toString());

        List<Hero> heroes = Arrays.asList(archer, fighter);

        for (Hero hero : heroes) {
            deployArcher(hero);
        }
    }

    private static void deployArcher(Hero hero) {
        if (hero.getRole().equals(Role.ARCHER)) {
            System.out.println("Archer ready!");
        }
    }
}
