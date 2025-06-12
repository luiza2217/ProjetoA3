package com.example;

public class Categoria {

    private int id_categoria;
    private String nome_categoria;
    
     // Construtor completo - usado quando todos os dados já estão disponíveis
    public Categoria(int id_categoria, String nome_categoria) {
        this.id_categoria = id_categoria;
        this.nome_categoria = nome_categoria;
      
    }

     // Construtor sem ID - usado para novos cadastros (ID será gerado pelo banco)
    public Categoria(String nome_categoria){
       this.nome_categoria = nome_categoria;
    }
    
    
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getNome_categoria() {
        return nome_categoria;
    }
    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }



@Override
public String toString() {
    return "ID: " + id_categoria + ", Nome: " + nome_categoria;
}


    
}
