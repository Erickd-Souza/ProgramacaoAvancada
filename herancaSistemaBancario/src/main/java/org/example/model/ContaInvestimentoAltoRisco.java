package org.example.model;

public class ContaInvestimentoAltoRisco extends ContaInvestimento{
    private double taxaRetirada = 0.05;
    private double saldoMinimo = 10000.00;

    public ContaInvestimentoAltoRisco(int numeroConta, String titular, Double saldo) {
        super(numeroConta, titular, saldo);

    }

    @Override
    public boolean sacar(double valor) {
        if(getSaldo() < saldoMinimo){
            System.out.println("Saldo insuficiente. Os saques são permitidos apartir de um saldo acima de R$ 10.000,00. ");
            return false;
        }
        double valorFinal = valor + (valor * taxaRetirada);
        if(getSaldo() >= valorFinal){
            setSaldo(getSaldo() - valorFinal);
            System.out.println("Saque de R$ " + " realizado com taxa de 5%. Saldo atual: R$ " + getSaldo());
            return true;
        }else{
            System.out.println("Saldo insuficiente para saque com taxa.");
            return false;
        }
    }
}
