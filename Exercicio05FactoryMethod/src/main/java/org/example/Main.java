package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número de 1 a 3 para escolher qual tipo de notificação:");
        System.out.println("1 - para Email");
        System.out.println("2 - para SMS");
        System.out.println("3 - para Push");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        String tipoNotificacao;
        switch (opcao) {
            case 1:
                tipoNotificacao = "email";
                break;
            case 2:
                tipoNotificacao = "sms";
                break;
            case 3:
                tipoNotificacao = "push";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.print("Digite a mensagem a ser enviada: ");
        String mensagem = scanner.nextLine();

        Notificacao notificacao = NotificacaoFactory.criarNotificacao(tipoNotificacao);
        notificacao.enviar(mensagem);
    }
}