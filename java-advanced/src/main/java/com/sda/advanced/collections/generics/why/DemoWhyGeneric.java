package com.sda.advanced.collections.generics.why;

import java.util.ArrayList;
import java.util.List;

public class DemoWhyGeneric {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);    // cast required

        // create a list designed for strings
        List listOfIntegers = new ArrayList();
        listOfIntegers.add(1);
        listOfIntegers.add(2);

        // a bad developer adds some other types beside strings
        listOfIntegers.add("ana");
        listOfIntegers.add(true);

        System.out.println(listOfIntegers);

        // i can't iterate because I have different objects inside
        for (Object integer : listOfIntegers) {
            int squaredInteger = 0;
            try {
                squaredInteger = (Integer) integer * (Integer) integer;
                System.out.println(squaredInteger);
            } catch (Exception e) {
                System.out.println("pai ce-ai facut ma nene maaa? " + integer + " is not an integer");
            }
        }
    }
}

