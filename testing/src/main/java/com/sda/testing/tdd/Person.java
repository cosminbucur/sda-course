package com.sda.testing.tdd;

public class Person {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public boolean isTeenager() {
        if (10 <= age && age < 20) {
            return true;
        } else {
            return false;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
