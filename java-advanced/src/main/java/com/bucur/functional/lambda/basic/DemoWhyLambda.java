package com.bucur.functional.lambda.basic;

interface Cleanable {

    void clean();
}

public class DemoWhyLambda {

    public static void main(String[] args) {
        withoutLambda();
        withLambda();
    }

    private static void withoutLambda() {
        Cleanable cleanable = new Cleanable() {
            @Override
            public void clean() {
                System.out.println("version without lambda");
            }
        };
    }

    private static void withLambda() {
        Cleanable cleanable = () -> System.out.println("version with lambda");
    }
}
