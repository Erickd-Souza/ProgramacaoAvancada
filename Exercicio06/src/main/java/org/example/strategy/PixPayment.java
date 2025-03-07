package org.example.strategy;

import org.example.strategy.PaymentStrategy;

import java.util.Random;

public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String pixCode = "Pix-" + new Random().nextInt(99999999);
        System.out.println("Pagamento R$"+amount+" via Pix efetuado com sucesso.");
        System.out.println("Código Pix: " + pixCode);
    }
}
