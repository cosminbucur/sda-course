package com.bucur.functional.lambda.jenkov;

public class DemoLambdaAsObjects {

    public static void main(String[] args) {
        MyComparator myComparator = (a1, a2) -> {
            return a1 > a2;
        };
        boolean result = myComparator.compare(2, 5);
    }

}
