package com.sda.advanced.oop.polymorphism;

public class DemoStaticPolymorphism {

    public static void main(String[] args) {
        // reference of type Human and object of type Boy
        Human boy = new Boy();
        // reference of type Human and object of type Human
        Human human = new Human();

        boy.walk();
        human.walk();

        // why can call run() on both references?
        boy.run();
        human.run();
    }
}
