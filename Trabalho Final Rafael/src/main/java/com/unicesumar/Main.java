package com.unicesumar;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;
import com.unicesumar.repository.VendaRepository;
import com.unicesumar.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository listaDeUsuarios = null;
        VendaRepository listaDeVendas = null;

        Connection conn = null;
        View view = null;
        // Parâmetros de conexão
        String url = "jdbc:sqlite:database.sqlite";

        // Tentativa de conexão
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                listaDeUsuarios = new UserRepository(conn);
                listaDeVendas = new VendaRepository(conn);
                view = new View(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            view.mostrarMenu();
            option = scanner.nextInt();
            view.selectOption(option, listaDeProdutos,listaDeUsuarios, listaDeVendas);
        } while (option != 6);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
