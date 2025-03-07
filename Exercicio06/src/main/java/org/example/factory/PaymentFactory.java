package org.example.factory;

import org.example.strategy.*;
public class PaymentFactory {
    public static PaymentStrategy createPaymentMethod (int opcao){
        switch (opcao){
            case 1:
                return new PixPayment();
            case 2:
                return new CreditCardPayment();
            case 3:
                return new BoletoPayment();
            default:
                throw new RuntimeException("Opção invalida!!!");
        }
    }
}
