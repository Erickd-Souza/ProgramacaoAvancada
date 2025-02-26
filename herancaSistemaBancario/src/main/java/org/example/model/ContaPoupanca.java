package org.example.model;

public class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca(int numeroConta, String titular, Double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso. Saldo atual de R$ "+ getSaldo());
            return true;
        } else{
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
    }

}
