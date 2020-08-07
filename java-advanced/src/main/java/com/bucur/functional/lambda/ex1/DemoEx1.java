package com.bucur.functional.lambda.ex1;

import java.util.function.Function;

@FunctionalInterface
interface MyFunctionalInterface {
    String doOneThing(String myString);
}

public class DemoEx1 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("my runnable");
            }
        };

        Runnable runnable2 = () -> System.out.println();
    }

    private static void useCustomFunctionalInterface() {
        MyObject myObject = new MyObject();
        MyFunctionalInterface myFunctionalInterface = parameter -> parameter + " from lambda";
        String result = myObject.add("Message", myFunctionalInterface);
        System.out.println(result);
    }

    public static void useStandardFunctionalInterface() {
        MyObject myObject = new MyObject();
        Function<String, String> function = parameter -> parameter + " from lambda";
        String result = myObject.add("Message", function);
    }
}

class MyObject {
    public String add(String myString, MyFunctionalInterface myFunctionalInterface) {
        return myFunctionalInterface.doOneThing(myString);
    }

    public String add(String myString, Function<String, String> standardFunction) {
        return standardFunction.apply(myString);
    }
}

