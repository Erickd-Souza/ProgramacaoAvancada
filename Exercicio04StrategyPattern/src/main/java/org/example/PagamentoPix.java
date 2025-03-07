package org.example;

import java.util.Random;

public class PagamentoPix implements EstrategiaPagamento{
    @Override
    public void PagamentoProcesso(double amount){
        String pixCode = "PIX" + new Random().nextInt(999999);
        System.out.println("Pagamento via Pix processado com sucesso!");
        System.out.println("Código Pix: " + pixCode);
        System.out.println("Valor: R$ " + amount);
    }
}
