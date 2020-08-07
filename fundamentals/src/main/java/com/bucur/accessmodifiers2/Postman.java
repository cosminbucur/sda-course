package com.bucur.accessmodifiers2;

import com.bucur.accessmodifiers2.home.Parent;

public class Postman {

    public void hasAccessTo() {
        System.out.println("public " + new Parent().phoneNumber);
    }

    public void noAccessTo() {
//        System.out.println("default " + new Parent().familyToilet);
//        System.out.println("protected " + new Parent().wealth);
//        System.out.println("private " + new Parent().personalClothes);
    }
}
