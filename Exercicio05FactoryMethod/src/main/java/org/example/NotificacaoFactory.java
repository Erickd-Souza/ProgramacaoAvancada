package org.example;

public class NotificacaoFactory {

    public static Notificacao criarNotificacao(String tipo) {
        switch (tipo.toLowerCase()) {
            case "email":
                return new EmailNotificacao();
            case "sms":
                return new SMS();
            case "push":
                return new Push();
            default:
                throw new IllegalArgumentException("Notificação desconhecida: " + tipo);
        }

    }
}
