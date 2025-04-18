package com.unicesumar.paymentMethods;

public class PagamentoProcesso {
    private PaymentMethod paymentMethod;

    public PagamentoProcesso(PaymentMethod estrategiaPagamento) {
        this.paymentMethod = estrategiaPagamento;
    }

    public void executePayment(double amount) {
       paymentMethod.pay(amount);
    }
}
