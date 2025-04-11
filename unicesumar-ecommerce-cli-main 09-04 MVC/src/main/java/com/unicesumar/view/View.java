package com.unicesumar.view;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class View {
    private String nomeProduto;
    private Double precoProduto;
    private String nomeUsuario;
    private String email;
    private String senha;



    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void mostrarMenu(){
        System.out.println("\n---MENU---");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listas Produtos");
        System.out.println("3 - Cadastrar Usuário");
        System.out.println("4 - Listar Usuários");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public void cadastrarProduto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastrar Produto");
        System.out.print("Digite o Nome: ");
        nomeProduto = scanner.nextLine();
        System.out.print("Digite o Preço: ");
        precoProduto = scanner.nextDouble();
    }

    public void mostrarLista(ProductRepository listaDeProdutos){
        System.out.println("Listar Produtos");
        List<Product> products = listaDeProdutos.findAll();
        products.forEach(System.out::println);
    }

    public void cadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastrar Usuário");
        System.out.print("Digite o Nome: ");
        nomeUsuario = scanner.nextLine();
        System.out.print("Digite o Email: ");
        email = scanner.next();
        System.out.print("Digite a Senha: ");
        senha = scanner.next();
    }

    public void listarUsuario(UserRepository listaDeUsuario){
        System.out.println("Listar Usuario");
        List<User> users = listaDeUsuario.findAll();
        users.forEach(System.out::println);
    }

    public void selectOption(int option, View view, ProductRepository listaDeProdutos, UserRepository listaDeUsuarios){
        switch (option) {
            case 1:
                view.cadastrarProduto();
                listaDeProdutos.save(new Product(view.getNomeProduto(), view.getPrecoProduto()));
                break;
            case 2:
                view.mostrarLista(listaDeProdutos);
                break;
            case 3:
                view.cadastrarUsuario();
                listaDeUsuarios.save(new User(view.getNomeUsuario(), view.getEmail(), view.getSenha()));
                break;
            case 4:
                view.listarUsuario(listaDeUsuarios);
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente");
        }
    }
}
