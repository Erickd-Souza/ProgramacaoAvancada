package org.example;

import org.example.factory.PaymentFactory;
import org.example.processo.PaymentProcessor;
import org.example.strategy.PaymentStrategy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu de Pagamento:");
        System.out.println("Selecione o Método de Pagamento:");
        System.out.println("[1] - Pix");
        System.out.println("[2] - Cartão de Crédito");
        System.out.println("[3] - Boleto");
        System.out.println("Opcão de Escolha: ");

        int opcao = scanner.nextInt();
        System.out.println("Digite o valor da Transação: ");
        double amount = scanner.nextDouble();

        try {
            PaymentStrategy paymentMethod = PaymentFactory.createPaymentMethod(opcao);
            PaymentProcessor processor = new PaymentProcessor(paymentMethod);
            processor.executePayment(amount);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}