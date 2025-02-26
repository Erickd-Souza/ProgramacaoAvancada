package org.example.model;

public class ContaSalario extends ContaCorrente {
    private int saqueGratuito = 1;
    private double taxaExtra = 5.00;

    public ContaSalario(int numeroConta, String titular, Double saldo, Double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
    }

    @Override
    public boolean sacar(double valor) {
        if(saqueGratuito > 0){
            saqueGratuito--;
            System.out.println("Saque gratuito de R$ " + valor + " realizado com sucesso.");
            return super.sacar(valor);
        }else{
            boolean saqueRealizado = super.sacar(valor + taxaExtra);
            if(saqueRealizado){
                System.out.println("Saque de R$ " + valor + " realizado com taxa de R$ 5,00. Saldo atual: R$ " + getSaldo());
            }
            return saqueRealizado;
        }
    }
}
