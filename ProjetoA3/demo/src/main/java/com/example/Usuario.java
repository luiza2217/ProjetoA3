package com.example;

public class Usuario {
    
private int id_usuario;
private String nome_usuario;
private String email;
private String senha;
private boolean administrador;




  // Construtor completo - usado quando todos os dados já estão disponíveis
    public Usuario(int id_usuario, String nome_usuario, String email, String senha, boolean administrador) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }

    // Construtor sem ID - usado para novos cadastros (ID será gerado pelo banco)
    public Usuario(String nome_usuario, String email, String senha, boolean administrador) {
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }

    // Construtor apenas com email e senha - usado para login/autenticação
    public Usuario(String email, String senha, boolean administrador) {
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }

 // Construtor apenas com RA e senha - usado para login/autenticação
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


public int getId_usuario() {
    return id_usuario;
}
public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
}
public String getNome_usuario() {
    return nome_usuario;
}
public void setNome_usuario(String nome_usuario) {
    this.nome_usuario = nome_usuario;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getSenha() {
    return senha;
}
public void setSenha(String senha) {
    this.senha = senha;
}
public boolean isAdministrador() {
    return administrador;
}
public void setAdministrador(boolean administrador) {
    this.administrador = administrador;
}


 @Override
public String toString() {
    return "ID: " + id_usuario + ", Nome: " + nome_usuario + ", Email: " + email + ", Admin: " + administrador;
}


}


