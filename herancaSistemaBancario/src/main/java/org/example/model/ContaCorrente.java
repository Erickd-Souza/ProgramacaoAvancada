package org.example.model;

public class ContaCorrente extends ContaBancaria {
    private Double limiteChequeEspecial;

    public ContaCorrente(int numeroConta, String titular, Double saldo, Double limiteChequeEspecial) {
        super(numeroConta, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public Double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(Double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo() + limiteChequeEspecial >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso. Saldo atual de R$ "+ getSaldo());
            return true;
        } else{
            System.out.println("Saldo insuficiente, para operação mesmo com cheque especial.");
            return false;
        }
    }


}
