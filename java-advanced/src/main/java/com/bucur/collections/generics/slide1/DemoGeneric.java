package com.bucur.collections.generics.slide1;

public class DemoGeneric {

    public static void main(String[] args) {
        ToyCar toyCar = new ToyCar();
        GenericBox<ToyCar> boxWithToyCar = new GenericBox<>(toyCar);
    }

}

