package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstrategiaPagamento estrategiaPagamento = null;

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        System.out.print("Opção: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                estrategiaPagamento = new PagamentoPix();
                break;
            case 2:
                estrategiaPagamento = new CartaoCredito();
                break;
            case 3:
                estrategiaPagamento = new Boleto();
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        PagamentoProcesso processor = new PagamentoProcesso(estrategiaPagamento);
        processor.executePayment(amount);

    }
}
