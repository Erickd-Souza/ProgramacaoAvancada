package org.example;

public class Push implements Notificacao{
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Push: " + mensagem);
    }
}
