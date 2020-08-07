package com.bucur.functional.lambda.tips;

public class DemoLambdaTips {

    // TODO: finish this
    public static void main(String[] args) {
        Foo useFoo = parameter -> parameter + " from lambda";
//        String result = useFoo.add("Message ", foo);
    }

    public static String add(String string, Foo foo) {
        return foo.method(string);
    }
}
