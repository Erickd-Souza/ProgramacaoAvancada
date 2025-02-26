package org.example.model;

public class Onibus extends Veiculo{
    private int quantidadeEixos;
    private int tanque = 200;
    private double consumo = 5.0;

    public Onibus(String marca, String modelo, int ano, int capacidadePassageiros, int quantidadeEixos) {
        super(marca, modelo, ano, capacidadePassageiros, "Diesel");
        if (quantidadeEixos < 6 || quantidadeEixos > 8) {
            throw new IllegalArgumentException("Ônibus deve ter entre 6 e 8 eixos");
        }
        this.quantidadeEixos = quantidadeEixos;
    }

    @Override
    public double calcularAutonomia() {
        return tanque * consumo;
    }
}
