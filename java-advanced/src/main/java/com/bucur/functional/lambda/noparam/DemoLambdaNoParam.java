package com.bucur.functional.lambda.noparam;

public class DemoLambdaNoParam {

    public static void main(String[] args) {
        // DONE: call the method in the functional interface

        // return a string
        // lambda -> (input) -> body
        // interface = implementation
        NoParam noParam = () -> "alex";
        String result = noParam.doSomething();
        System.out.println(result);
    }
}
