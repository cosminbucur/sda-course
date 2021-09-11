package com.sda.fundamentals.operators;

public class DemoLogicalOperators {

    public static void main(String[] args) {
        boolean trueStatement = true;
        boolean falseStatement = false;

        // conjunction
        System.out.println(trueStatement && falseStatement);    // false

        // disjunction
        System.out.println(trueStatement || falseStatement);    // true

        // negation
        System.out.println(!(trueStatement || falseStatement));   // false    // false
    }
}
