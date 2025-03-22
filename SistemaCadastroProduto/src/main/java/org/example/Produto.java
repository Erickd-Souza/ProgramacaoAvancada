package org.example;

public class Produto {
   private int codigo;
   private String nome;
   private Double preco;

    public Produto(int codigo, String nome, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

   void exibirInfo(){
       System.out.println("\n...IMPRIMINDO PRODUTO...");
       System.out.println("Código do Produto: " + getCodigo());
       System.out.println("Nome Produto: " + getNome());
       System.out.println("Preço do Produto: R$ " + getPreco());
    }

}
