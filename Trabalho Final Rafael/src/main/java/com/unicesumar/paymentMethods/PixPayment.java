package com.unicesumar.paymentMethods;

import java.util.Random;

public class PixPayment implements PaymentMethod {
    public void pay(double amount) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder rondBatata = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 24; i++) { // 24 é o tamanho da string
            rondBatata.append(caracteres.charAt(rand.nextInt(caracteres.length())));
        }
        System.out.println("Aguarde, efetuando pagamento...");
        System.out.println("Pagamento confirmado com sucesso via PIX. Chave de Autenticação: " + rondBatata.toString());
    }
}