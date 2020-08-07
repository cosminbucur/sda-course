package com.bucur.functional.lambda.jenkov;

import java.util.function.UnaryOperator;

public class DemoOperator {

    public static void main(String[] args) {
        UnaryOperator<Integer> toSquareUnaryOperator = i -> i * i;
        System.out.println(toSquareUnaryOperator.apply(5));
    }

}
