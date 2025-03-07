package org.example;

import java.util.Scanner;

public class CartaoCredito implements EstrategiaPagamento{
    @Override
        public void PagamentoProcesso(double amount) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o número do cartão de crédito: ");
            String numCartao = scanner.nextLine();
            System.out.println("Pagamento via Cartão de Crédito processado com sucesso!");
            System.out.println("Número do cartão: " + numCartao);
            //System.out.println(String.format("Valor: R$ " + amount));
            System.out.println(String.format("Valor: R$ %.2f", amount));
        }
}
