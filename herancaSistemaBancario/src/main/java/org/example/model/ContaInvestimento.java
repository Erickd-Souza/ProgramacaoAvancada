package org.example.model;

public class ContaInvestimento extends ContaBancaria {
    private double taxaRetirada = 0.02;

    public ContaInvestimento(int numeroConta, String titular, Double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        double valorFinal = valor + (valor * taxaRetirada);
        if(getSaldo() >= valorFinal){
            setSaldo(getSaldo()-valorFinal);
            System.out.println("Saque de R$ " + valor + " realizado com taxa de 2%. Saldo atual: R$ " + getSaldo());
            return true;
        }else {
            System.out.println("Saldo insuficiente para saque com taxa.");
            return false;
        }
    }
}
