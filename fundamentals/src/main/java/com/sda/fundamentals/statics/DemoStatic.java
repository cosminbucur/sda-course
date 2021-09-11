package com.sda.fundamentals.statics;

public class DemoStatic {

    public static void main(String[] args) {
        // access static variable
        System.out.println(ClassWithStatics.STATIC_VARIABLE);

        // call static method
        ClassWithStatics.staticMethod();

        // access non static variable
        ClassWithoutStatics instance = new ClassWithoutStatics();
        System.out.println(instance.id);

        // call non static method
        instance.nonStaticMethod();
    }
}
