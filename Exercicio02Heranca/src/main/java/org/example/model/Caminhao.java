package org.example.model;
public class Caminhao extends Veiculo{
    private double capacidadeCarga;
    private int tanque = 300;
    private double consumo = 6.0;

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, double capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, "Diesel");
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia() {
        double reducao = Math.min(0.25,capacidadeCarga * 0.01);
        double consumoFinal = consumo * (1 - reducao);
        return tanque * consumoFinal ;
    }
}
