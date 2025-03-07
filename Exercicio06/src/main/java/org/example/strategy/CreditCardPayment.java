package org.example.strategy;

import org.example.strategy.PaymentStrategy;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o número do Cartão de Crédito: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Pagamento de R$"+ amount + " efetuado com sucesso com o Cartão " + cardNumber);
    }
}
