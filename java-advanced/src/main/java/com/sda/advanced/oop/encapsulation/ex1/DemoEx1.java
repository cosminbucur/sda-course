package com.sda.advanced.oop.encapsulation.ex1;

public class DemoEx1 {

    public static void main(String[] args) {
        Dog dog = new Dog("", "");
        System.out.println("age after constructor" + dog.getAge());
        dog.setAge(10);
        System.out.println("age after setter" + dog.getAge());
        dog.setWeight(50);
    }
}
