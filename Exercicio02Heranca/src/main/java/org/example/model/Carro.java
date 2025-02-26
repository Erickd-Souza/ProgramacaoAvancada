package org.example.model;

public class Carro extends Veiculo{
    private String TipoCarro;
    private int tanque = 50;
    private double consumo = 12.0;

    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String tipoCarro) {
        super(marca, modelo, ano, capacidadePassageiros, "Gasolina");
        this.TipoCarro = tipoCarro;
    }


    @Override
    public double calcularAutonomia() {
        return tanque * consumo;
    }
}
