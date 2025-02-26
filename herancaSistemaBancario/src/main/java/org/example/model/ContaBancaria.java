package org.example.model;

public abstract class ContaBancaria {
    private int numeroConta;
    private String titular;
    private Double saldo;

    public ContaBancaria(int numeroConta, String titular, Double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor){
        saldo += valor;
        System.out.println("Depósito realizado de R$ " + valor +". Saldo Atual: R$ " + saldo);
    }

    public abstract boolean sacar(double valor);

    public void exibirInformacoes(){
        System.out.println("--------------------------------------------");
        System.out.println("Numero da Conta: " + numeroConta);
        System.out.println("Titular da Conta: " + titular);
        System.out.println("Saldo da Conta: " + saldo);

    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
