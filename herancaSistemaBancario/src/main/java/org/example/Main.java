package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        // Criando as contas com os dados iniciais
        ContaCorrente contaCorrente = new ContaCorrente(123, "João", 1000.00, 500.00);
        ContaPoupanca contaPoupanca = new ContaPoupanca(456, "Maria", 500.00);
        ContaInvestimento contaInvestimento = new ContaInvestimento(789, "Carlos", 2000.00);
        ContaInvestimentoAltoRisco contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco(101, "Ana", 12000.00);
        ContaSalario contaSalario = new ContaSalario(202, "Felipe", 1500.00, 1000.00);

        // Realizando depósitos
        System.out.println("Realizando Depósitos:");
        contaCorrente.depositar(500.00);   // Depósito de R$ 500.00 na conta corrente
        contaPoupanca.depositar(200.00);   // Depósito de R$ 200.00 na conta poupança
        contaInvestimento.depositar(1000.00);  // Depósito de R$ 1000.00 na conta investimento
        contaInvestimentoAltoRisco.depositar(2000.00);  // Depósito de R$ 2000.00 na conta investimento alto risco
        contaSalario.depositar(300.00);    // Depósito de R$ 300.00 na conta salário

        // Exibindo informações após depósitos
        System.out.println("\nExibindo Informações das Contas:");
        contaCorrente.exibirInformacoes();
        contaPoupanca.exibirInformacoes();
        contaInvestimento.exibirInformacoes();
        contaInvestimentoAltoRisco.exibirInformacoes();
        contaSalario.exibirInformacoes();

        // Realizando saques
        System.out.println("\nRealizando Saques:");

        // Saque na Conta Corrente (utilizando limite do cheque especial)
        contaCorrente.sacar(1200.00);   // Saque de R$ 1200.00
        // Saque na Conta Poupança (saldo insuficiente)
        contaPoupanca.sacar(600.00);    // Saque de R$ 600.00
        // Saque na Conta Investimento (com taxa de 2%)
        contaInvestimento.sacar(1500.00);  // Saque de R$ 1500.00 com taxa de 2%
        // Saque na Conta Investimento Alto Risco (com taxa de 5% e saldo mínimo)
        contaInvestimentoAltoRisco.sacar(1500.00);  // Saque de R$ 1500.00 com taxa de 5%
        // Saque na Conta Salário (primeiro saque gratuito)
        contaSalario.sacar(500.00);     // Saque gratuito de R$ 500.00
        // Saque na Conta Salário (segundo saque com taxa extra)
        contaSalario.sacar(200.00);     // Saque de R$ 200.00 com taxa extra de R$ 5,00
    }
}
