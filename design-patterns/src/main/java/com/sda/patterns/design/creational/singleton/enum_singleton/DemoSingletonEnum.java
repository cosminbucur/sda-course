package com.sda.patterns.design.creational.singleton.enum_singleton;

public class DemoSingletonEnum {

    public static void main(String[] args) {
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();

        System.out.println(enumSingleton1.getInfo()); //Initial enum info

        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");

        System.out.println(enumSingleton1.getInfo()); // New enum info
        System.out.println(enumSingleton2.getInfo()); // New enum info

    /*
        when serializing an enum, field variables are not getting serialized.
        For example, if we serialize and deserialize the SingletonEnum class,
        we will lose the value of the int value field
    */
    }
}
