package com.unicesumar.repository;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.Venda;

import java.sql.*;
import java.util.*;

public class VendaRepository implements EntityRepository<Venda>{
    private final Connection connection;

    public VendaRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Venda entity) {
        String query = "INSERT INTO sales VALUES (?, ?, ?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, entity.getUuid().toString());
            stmt.setString(2, entity.getUuidUsuario().toString());
            stmt.setString(3, entity.getPaymentType());
            stmt.setTimestamp(4, entity.getSaleDate());
            stmt.executeUpdate();
        String vendasDeProdutosquery = "INSERT INTO sale_products VALUES (?, ?)";
            PreparedStatement stm = this.connection.prepareStatement(vendasDeProdutosquery);
            for(Product product : entity.getProducts()) {
                stm.setString(1, entity.getUuid().toString());
                stm.setString(2, product.getUuid().toString());
                stm.addBatch();
            }
            stm.executeBatch();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Venda> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Venda> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {
        String query = "DELETE FROM sales WHERE uuid = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, id.toString());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


