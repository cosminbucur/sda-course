package com.sda.advanced.oop.polymorphism;

public class DemoDynamicPolymorphism {

    public static void main(String[] args) {
        // reference of type Human and object of type Boy
        Animal animal = new Animal();
        // reference of type Human and object of type Human
        Animal dog = new Dog();

        animal.walk();
        dog.walk();
    }
}
