package org.example.model;

public class CaminhaoRefrigerado extends Caminhao{
    private double temperaturaMinima;

    public CaminhaoRefrigerado(String marca, String modelo, int ano, int capacidadePassageiros, double capacidadeCarga,  double temperaturaMinima) {
        super(marca, modelo, ano, capacidadePassageiros, capacidadeCarga);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double calcularAutonomia() {
        return super.calcularAutonomia() * 0.9;
    }
}
