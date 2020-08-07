package com.bucur.accessmodifiers2.home;

public class Brother extends Parent {

    public void hasAccessTo() {
        System.out.println("public " + super.phoneNumber);
        System.out.println("protected " + super.wealth);
        System.out.println("default " + super.familyToilet);
    }

    public void noAccessTo() {
//        System.out.println("private " + super.personalClothes);
    }
}
