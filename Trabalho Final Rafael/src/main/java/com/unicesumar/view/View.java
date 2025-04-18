package com.unicesumar.view;

import com.unicesumar.PaymentMethodFactory;
import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.entities.Venda;
import com.unicesumar.paymentMethods.*;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;
import com.unicesumar.repository.VendaRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class View {
    private final Connection connection;

    PaymentMethod paymentMethod = null;
    PaymentType paymentType = null;

    public View(Connection connection) {
        this.connection = connection;
    }

    public User validarUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Email do Usuario: ");
        String email = scanner.next();
        String query = "SELECT * FROM users WHERE email = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                System.out.println("O Usuário existe na Base de Dados: " + resultSet.getString("name"));
                UUID uuid = UUID.fromString(resultSet.getString("uuid"));
                String nomeDoUsuario = resultSet.getString("name");
                String emailEncotrado = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(uuid, nomeDoUsuario, emailEncotrado, password);
            }else {
                System.out.println("O usuário não foi encontrado na Base de Dados.");
                return  null;
            }
        }catch (Exception e){
            System.out.println("Erro inesperado: " + e.getMessage());
            return null;
        }
    }

    public List<Product> procurarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Id do Produto para MAIS produtos coloque separado por virgula: ");
        String uuidBusca = scanner.nextLine();
        String[] ids = uuidBusca.split(",");
        List<Product> produtosEncontrados = new ArrayList<>();
        for (String id : ids) {
            try {
                UUID uuid = UUID.fromString(id.trim());
                String query = "SELECT * FROM products WHERE uuid = ?";
                PreparedStatement stmt = this.connection.prepareStatement(query);
                stmt.setString(1, uuid.toString());
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    System.out.println("O Produto existe na Base de Dados: " + resultSet.getString("name"));
                    String nome = resultSet.getString("name");
                    double preco = resultSet.getDouble("price");
                    Product produto = new Product(uuid, nome, preco);
                    produtosEncontrados.add(produto);
                } else {
                    System.out.println("O Produto não foi encontrado na Base de Dados.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("ID inválido deve ser um UUID): " + id.trim());
            } catch (SQLException e) {
                System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
        if (!produtosEncontrados.isEmpty()) {
            formaDePagamento();
        }
        return produtosEncontrados;
    }
    public void mostrarMenu(){
        System.out.println("\n      <<< MENU >>>     ");
        System.out.println("+-----------------------+");
        System.out.println("| 1 - Cadastrar Produto |");
        System.out.println("|-----------------------|");
        System.out.println("| 2 - Listas Produtos   |");
        System.out.println("|-----------------------|");
        System.out.println("| 3 - Cadastrar Usuário |");
        System.out.println("|-----------------------|");
        System.out.println("| 4 - Listar Usuários   |");
        System.out.println("+-----------------------+");
        System.out.println("| 5 - CADASTRAR VENDA   |");
        System.out.println("+-----------------------+");
        System.out.println("        6 - Sair         ");
        System.out.println("Escolha uma opção: ");
    }

    public void cadastrarProduto(ProductRepository listaDeProdutos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastrar Produto");
        System.out.print("Digite o Nome: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o Preço: ");
        double precoProduto = scanner.nextDouble();
        listaDeProdutos.save(new Product(nomeProduto, precoProduto));
    }

    public void mostrarLista(ProductRepository listaDeProdutos){
        System.out.println("Listar Produtos");
        List<Product> products = listaDeProdutos.findAll();
        products.forEach(System.out::println);
    }

    public void cadastrarUsuario(UserRepository listaDeUsuarios){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastrar Usuário");
        System.out.print("Digite o Nome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o Email: ");
        String email = scanner.next();
        System.out.print("Digite a Senha: ");
        String senha = scanner.next();
        listaDeUsuarios.save(new User(nomeUsuario,email, senha));
        System.out.println("Usuario cadastrado com Sucesso");
    }

    public void listarUsuario(UserRepository listaDeUsuario){
        System.out.println("Listar Usuario");
        List<User> users = listaDeUsuario.findAll();
        users.forEach(System.out::println);
    }

    public void formaDePagamento(){
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a forma de pagamento:");
        System.out.println(" 1 - Cartão de Crédito");
        System.out.println(" 2 - Boleto");
        System.out.println(" 3 - PIX");
        System.out.print("Opção: ");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                paymentType = PaymentType.CARTAO;
                break;
            case 2:
                paymentType = PaymentType.BOLETO;
                break;
            case 3:
                paymentType = PaymentType.PIX;
                break;
            default:
                System.out.println("Opção Invalida!!!");
        }
        paymentMethod = PaymentMethodFactory.create(paymentType);

    }

    public void realizarVenda(VendaRepository vendaRepository){
        User usuario = validarUsuario();
        if(usuario == null)
            return;
        List<Product> produtos = procurarProduto();
        if(produtos == null)
            return;
        double valorTotal = produtos.stream().mapToDouble(Product::getPrice).sum();
        PagamentoProcesso pagamento = new PagamentoProcesso(paymentMethod);
        pagamento.executePayment(valorTotal);
        resumoDeVenda(usuario,produtos,valorTotal,paymentType.toString());
        Venda venda = new Venda(usuario.getUuid(),paymentType.toString(), produtos);
        vendaRepository.save(venda);
    }

    public void resumoDeVenda(User user ,List<Product> products, double valorTotal, String paymentType){
        System.out.println("==================================================");
        System.out.println("                 Resumo da venda:                 ");
        System.out.println("  Cliente:"+ user.getName());
        System.out.println("  Produtos:");
        products.forEach(product -> System.out.println(product.detalhes()));
        System.out.println("  Valor total: R$"+ valorTotal);
        System.out.println("  Pagamento: " + paymentType);
        System.out.println("==================================================");
        System.out.println("Venda registrada com sucesso!");
    }

    public void selectOption(int option, ProductRepository listaDeProdutos, UserRepository listaDeUsuarios, VendaRepository listaDeVendas){
        switch (option) {
            case 1:
                cadastrarProduto(listaDeProdutos);
                break;
            case 2:
                mostrarLista(listaDeProdutos);
                break;
            case 3:
                cadastrarUsuario(listaDeUsuarios);
                break;
            case 4:
                listarUsuario(listaDeUsuarios);
                break;
            case 5:
                realizarVenda(listaDeVendas);
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente");
        }
    }
}
