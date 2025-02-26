package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Carro("Toyota", "Corolla", 2022, 5, "Sedan");
        Veiculo caminhao = new Caminhao("Volvo", "FH16", 2020, 2,15);
        Veiculo onibus = new Onibus("Mercedes", "O500", 2019, 40, 6);
        Veiculo carroEletrico = new CarroEletrico("Tesla", "Model 3", 2023, 5, "Sedan",75);
        Veiculo caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "R450", 2021, 2, 15 , -18);

        Veiculo[] veiculos = {carro, caminhao, onibus, carroEletrico, caminhaoRefrigerado};

        for (Veiculo v : veiculos) {
            v.exibirDetalhes();
            System.out.println("Autonomia: " + v.calcularAutonomia() + " km");
            System.out.println("-----------------------------");
        }
    }
}