package com.sda.patterns.design.behavioral.strategy.strategies;

public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
