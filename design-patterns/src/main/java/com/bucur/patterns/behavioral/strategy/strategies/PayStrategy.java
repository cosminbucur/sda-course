package com.bucur.patterns.behavioral.strategy.strategies;

public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
