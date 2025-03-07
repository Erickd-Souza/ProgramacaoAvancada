package org.example;

public class SMS implements Notificacao{
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " +  mensagem);
    }
}
