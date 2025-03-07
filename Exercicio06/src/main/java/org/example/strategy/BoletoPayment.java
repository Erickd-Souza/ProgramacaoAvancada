package org.example.strategy;

import org.example.strategy.PaymentStrategy;

import java.util.Random;

public class BoletoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String BoletoCode = "Boleto-" + new Random().nextInt(99999999);
        System.out.println("Pagamento R$" + amount + " via Boleto efetuado com sucesso.");
        System.out.println("Código do Boleto: " + BoletoCode);
    }
}
