package org.example.model;

public class CarroEletrico extends Carro{
    private double bateriaKwh;

    public CarroEletrico(String marca, String modelo, int ano, int capacidadePassageiros, String tipoCarro, double bateriaKwh) {
        super(marca, modelo, ano, capacidadePassageiros, tipoCarro);
        this.bateriaKwh = bateriaKwh;
        this.setCombustivel("Elétrico");
    }

    @Override
    public double calcularAutonomia() {
        double consumo = 5.0;
        return bateriaKwh * consumo;
    }
}
