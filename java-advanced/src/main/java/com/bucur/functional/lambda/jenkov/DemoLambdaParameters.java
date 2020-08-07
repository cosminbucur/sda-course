package com.bucur.functional.lambda.jenkov;

public class DemoLambdaParameters {

    public static void main(String[] args) {

    }

    private void zeroParameters() {
        StateOwner stateOwner = new StateOwner();
//        stateOwner.addStateListener(
//            () -> System.out.println("Zero parameter lambda")
//        );

    }

    private void oneParameter() {
//        Function<String> oneParamFunction = (param) -> System.out.println("One parameter: " + param);
    }

    private void multipleParameters() {
//        Function<String, String> twoParamFunction = (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
    }
}
