package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer , Produto> produtos = new HashMap<>();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1- Cadastrar produto");
            System.out.println("2- Buscar produto por código");
            System.out.println("3- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opção de cadastro selecionada.");
                    System.out.println("------------------------------");
                    System.out.print("Informe o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o preço do produto: ");
                    double preco = scanner.nextDouble();


                    Produto produto = new Produto(codigo, nome, preco);
                    produtos.put(codigo,new Produto(codigo,nome,preco));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.println("Opção de busca selecionada.");
                    System.out.print("Informe o código do produto para busca: ");
                    int codigoDeBusca = scanner.nextInt();
                    scanner.nextLine();
                    if(produtos.containsKey(codigoDeBusca)){
                        produtos.get(codigoDeBusca).exibirInfo();
                    }else{
                        System.out.println("Produto Não Encontrado!!!");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}