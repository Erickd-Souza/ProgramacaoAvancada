package com.unicesumar.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Venda extends Entity{
    private final UUID uuidUsuario;
    private final String paymentType;
    private final Timestamp saleDate;
    private List<Product> products;


    public Venda(UUID uuidUsuario, String paymentType, List<Product> products) {
        super();
        this.uuidUsuario = uuidUsuario;
        this.paymentType = paymentType;
        this.products = products;
        this.saleDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public Venda(UUID uuid, UUID uuidUsuario, String paymentType, Timestamp saleDate) {
        super(uuid);
        this.paymentType = paymentType;
        this.uuidUsuario = uuidUsuario;
        this.saleDate = saleDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public UUID getUuidUsuario() {
        return uuidUsuario;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

}
