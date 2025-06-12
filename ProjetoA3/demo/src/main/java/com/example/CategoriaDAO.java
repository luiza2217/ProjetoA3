package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // Adiciona uma nova categoria ao banco
    public boolean adicionar(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome_categoria) VALUES (?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, categoria.getNome_categoria());

            int rows = stmt.executeUpdate();

            // Captura o ID gerado pelo banco e define no objeto
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    categoria.setId_categoria(rs.getInt(1));
                }
            }

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar categoria: " + e.getMessage());
            return false;
        }
    }

    // Lista todas as categorias cadastradas
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id_categoria, nome_categoria FROM categoria";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nome_categoria")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias: " + e.getMessage());
        }
        return categorias;
    }

    // Atualiza uma categoria existente
    public boolean editar(Categoria categoria) {
        String sql = "UPDATE categoria SET nome_categoria = ? WHERE id_categoria = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome_categoria());
            stmt.setInt(2, categoria.getId_categoria());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar categoria: " + e.getMessage());
            return false;
        }
    }

    // Remove uma categoria com base no ID
    public boolean excluir(int id_categoria) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_categoria);

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
            return false;
        }
    }
}
