package com.unicesumar.entities;

import java.util.UUID;

public class Product extends Entity {
    private final String name;
    private final double price;

    public Product(UUID uuid, String name, double price) {
        super(uuid);
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("ID: [%s] %s - R$ %s",this.getUuid(), this.name, this.price);
    }

    public String detalhes() {
        return String.format("   -> %s - R$ %s", this.name, this.price);
    }

}
