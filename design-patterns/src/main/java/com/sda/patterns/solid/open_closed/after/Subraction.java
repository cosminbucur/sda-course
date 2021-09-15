package com.sda.patterns.solid.open_closed.after;

public class Subraction implements IOperation {

    private double firstOperand;
    private double secondOperand;
    private double result = 0.0;

    public Subraction(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public void performOperation() {
        this.result = this.firstOperand - this.secondOperand;
    }
}
