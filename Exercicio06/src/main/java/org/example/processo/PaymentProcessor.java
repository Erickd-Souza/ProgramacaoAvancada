package org.example.processo;

import org.example.strategy.PaymentStrategy;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount){
        strategy.processPayment(amount);
    }
}
