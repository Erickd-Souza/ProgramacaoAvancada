package org.example;

import java.util.Random;

public class Boleto implements EstrategiaPagamento{
    @Override
        public void PagamentoProcesso(double amount) {
            String boletoCode = "237" + new Random().nextInt(999999999);
            System.out.println("Pagamento via Boleto gerado com sucesso!");
            System.out.println("Código do Boleto: " + boletoCode);
            System.out.println("Valor: R$ " + amount);
        }
}
