package com.bucur.functional.lambda.why;

public class DemoWhyLambda {

    public static void main(String[] args) {
        withoutLambda();
        withLambda();
    }

    private static void withoutLambda() {
        // DONE: implement interface without lambda
        // anonymous implementation
        Cleanable cleanable = new Cleanable() {
            @Override
            public void clean() {
                System.out.println("cleaning");
            }
        };
        cleanable.clean();
    }

    private static void withLambda() {
        // DONE: implement interface with lambda
        Cleanable cleanable = () -> System.out.println("washing");
        cleanable.clean();
    }
}
