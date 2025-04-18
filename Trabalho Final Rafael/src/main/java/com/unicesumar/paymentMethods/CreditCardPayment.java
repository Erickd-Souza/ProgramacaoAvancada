package com.unicesumar.paymentMethods;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Aguarde, efetuando pagamento...");
        System.out.println("Pagamento efetuado com sucesso via cartão de crédito");
    }
}