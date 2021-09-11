package com.sda.advanced.functional.lambda.oneparam;

public class DemoLambdaOneParam {

    public static void main(String[] args) {
        // DONE: call the method in the functional interface

        // add 5 to a number
        OneParam oneParam = (int someNumber) -> 5 + someNumber;
        int result = oneParam.doSomething(2);
        System.out.println(result);
    }
}
