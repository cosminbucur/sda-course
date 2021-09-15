package com.sda.patterns.coupling.loose;

/*
If the only knowledge that class A has about class B,
is what class B has exposed through its interface, then
class A and class B are said to be loosely coupled.
 */
public class DemoLooseCoupling {

    public static void main(String[] args) {
        Topic topic = new Topic1();
        topic.understand();
    }
}

