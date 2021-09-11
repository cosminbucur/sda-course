package com.bucur.solid.open_closed.before;

import java.security.InvalidParameterException;

public class SimpleCalculator implements ICalculator {

    @Override
    public void calculate(IOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException("some message");
        }

        if (operation instanceof Addition) {
            Addition addition = (Addition) operation;
            addition.setResult(addition.getFirstOperand() + addition.getSecondOperand());
        } else if (operation instanceof Substraction) {
            Substraction substraction = (Substraction) operation;
            substraction.setResult(substraction.getFirstOperand() - substraction.getSecondOperand());
        }
    }
}
