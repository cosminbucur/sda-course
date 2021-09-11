package com.sda.advanced.functional.lambda.twoparam;

public class DemoLambdaTwoParam {

    public static void main(String[] args) {
        // DONE: call the method in the functional interface

        // concatenate some strings
        TwoParam twoParam = (String one, String two) -> one.concat(two).toUpperCase();
        String result = twoParam.doSomething("paul", "ene");
        System.out.println(result);
    }
}
