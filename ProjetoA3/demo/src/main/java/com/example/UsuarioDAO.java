package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    //f
    public Usuario buscarPorId(int id_suario) {
    String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id_suario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Usuario(
                rs.getInt("id_usuario"),
                rs.getString("nome_usuario"),
                rs.getString("email"),
                rs.getString("senha"),
                rs.getBoolean("admin")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
    }

    return null;
}

    
    
    
    
    
    
    
    
    
    
    // Autentica um usuário com base em email e senha
    public boolean autenticar(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se encontrar o usuário
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    // Lista todos os usuários cadastrados
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, nome_usuario, email, senha, administrador FROM usuario";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nome_usuario"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getBoolean("administrador")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    // Adiciona um novo usuário (deixa o banco gerar o ID automaticamente)
    public boolean adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome_usuario, email, senha, administrador) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setBoolean(4, usuario.isAdministrador());

            int rows = stmt.executeUpdate();

            // Recupera o ID gerado e atualiza o objeto
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId_usuario(rs.getInt(1));
                }
            }

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
            return false;
        }
    }

    // Atualiza os dados de um usuário existente
    public boolean editar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome_usuario = ?, email = ?, senha = ?, administrador = ? WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setBoolean(4, usuario.isAdministrador());
            stmt.setInt(5, usuario.getId_usuario());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar usuário: " + e.getMessage());
            return false;
        }
    }

    // Remove um usuário pelo ID
    public boolean excluir(int id_usuario) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_usuario);

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
            return false;
        }
    }
}
