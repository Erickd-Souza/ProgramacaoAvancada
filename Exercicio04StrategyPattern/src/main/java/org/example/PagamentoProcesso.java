package org.example;

public class PagamentoProcesso {

        private EstrategiaPagamento estrategiaPagamento;

        public PagamentoProcesso(EstrategiaPagamento estrategiaPagamento) {
            this.estrategiaPagamento = estrategiaPagamento;
        }

        public void executePayment(double amount) {
            estrategiaPagamento.PagamentoProcesso(amount);
        }
}
