package com.bucur.accessmodifiers2.home;

public class Thief {

    public void hasAccessTo() {
        System.out.println("public " + new Parent().phoneNumber);
        System.out.println("protected " + new Parent().wealth);
        System.out.println("default " + new Parent().familyToilet);
    }

    public void noAccessTo() {
//        System.out.println("private " + new Parent().personalClothes);
    }
}
