package com.bucur.functional.lambda.jenkov;

public class DemoLambdaBody {

    public static void main(String[] args) {

    }

    private static void lambdaFunctionBody() {
        StateOwner stateOwner = new StateOwner();

        stateOwner.addStateListener(
            (oldState, newState) -> {
                System.out.println("Old state: " + oldState);
                System.out.println("New state: " + newState);
            }
        );
    }

//    private static void returingAValueFromLambda() {
//        Printable printable = new Printable() {
//            @Override
//            public void printIt(String text) {
//                (param) -> {
//                    System.out.println("param: " + param);
//                    return "return value";
//                }
//            }
//        };
//
//    }
}
