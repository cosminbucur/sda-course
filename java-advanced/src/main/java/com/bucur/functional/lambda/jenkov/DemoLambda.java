package com.bucur.functional.lambda.jenkov;

// http://tutorials.jenkov.com/java/lambda-expressions.html
public class DemoLambda {

    public static void main(String[] args) {

    }

    private static void java7AnonymousInterfaceImplementation() {
        StateOwner stateOwner = new StateOwner();

        stateOwner.addStateListener(new StateChangeListener() {
            @Override
            public void onStateChange(String oldState, String newState) {
                // do something with the two states
            }
        });
    }

    private static void java8Lambda() {
        StateOwner stateOwner = new StateOwner();

        stateOwner.addStateListener(
            // lambda
            (oldState, newState) -> System.out.println("state changed")
        );
    }
}
