package com.example;

import java.math.BigDecimal;

public class Produto {

    private int id_produto;
    private String nome_produto;
    private int id_categoria;
    private int quantidade_entrada;
    private int quantidade_saida;
    private BigDecimal preco;
    private String numero_calcado;
    
    
    // Construtor completo - usado quando todos os dados já estão disponíveis
    public Produto(int id_produto, String nome_produto, int id_categoria, int quantidade_entrada, int quantidade_saida, BigDecimal preco, String numero_calcado) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.preco = preco;
        this.id_categoria = id_categoria;
        this.quantidade_saida = quantidade_saida;
        this.quantidade_entrada = quantidade_entrada;
        this.numero_calcado = numero_calcado;
    }


    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome_produto() {
        return nome_produto;
    }
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public int getQuantidade_entrada() {
        return quantidade_entrada;
    }
    public void setQuantidade_entrada(int quantidade_entrada) {
        this.quantidade_entrada = quantidade_entrada;
    }
    public int getQuantidade_saida() {
        return quantidade_saida;
    }
    public void setQuantidade_saida(int quantidade_saida) {
        this.quantidade_saida = quantidade_saida;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

   public String getNumero_calcado() {
        return numero_calcado;
   }
   public void setNumero_calcado(String numero_calcado) {
          this.numero_calcado = numero_calcado;
   }
    

    @Override
public String toString() {
    return "ID: " + id_produto + ", Nome: " + nome_produto + ", Categoria ID: " + id_categoria +
           ", Entrada: " + quantidade_entrada + ", Saída: " + quantidade_saida + ", Preço: " + preco + ", Número do Calçado: " + numero_calcado;
}




}


