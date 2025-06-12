package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ProdutoDAO {

    // f
    public Produto buscarPorId(int idProduto) {
    String sql = "SELECT * FROM produto WHERE id_produto = ?";
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idProduto);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Produto(
                rs.getInt("id_produto"),
                rs.getString("nome_produto"),
                rs.getInt("id_categoria"),
                rs.getInt("quantidade_entrada"),
                rs.getInt("quantidade_saida"),
                rs.getBigDecimal("preco"),
                rs.getString("numero_calcado")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar produto por ID: " + e.getMessage());
    }

    return null;
}    
    
    
    // Adiciona um novo produto no banco
    public boolean adicionar(Produto produto) {
        String sql = "INSERT INTO produto (nome_produto, id_categoria, quantidade_entrada, quantidade_saida, preco, numero_calcado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome_produto());
            stmt.setInt(2, produto.getId_categoria());
            stmt.setInt(3, produto.getQuantidade_entrada());
            stmt.setInt(4, produto.getQuantidade_saida());
            stmt.setBigDecimal(5, produto.getPreco());
            stmt.setString(6, produto.getNumero_calcado());

            int rows = stmt.executeUpdate();

            // Captura o ID gerado pelo banco e define no objeto
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setId_produto(rs.getInt(1));
                }
            }

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
            return false;
        }
    }

    // Lista todos os produtos cadastrados
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id_produto, nome_produto, id_categoria, quantidade_entrada, quantidade_saida, preco, numero_calcado FROM produto";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id_produto"),
                    rs.getString("nome_produto"),
                    rs.getInt("id_categoria"),
                    rs.getInt("quantidade_entrada"),
                    rs.getInt("quantidade_saida"),
                    rs.getBigDecimal("preco"),
                    rs.getString("numero_calcado")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

    // Atualiza os dados de um produto existente
    public boolean editar(Produto produto) {
        String sql = "UPDATE produto SET nome_produto = ?, id_categoria = ?, quantidade_entrada = ?, quantidade_saida = ?, preco = ?, numero_calcado = ? WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome_produto());
            stmt.setInt(2, produto.getId_categoria());
            stmt.setInt(3, produto.getQuantidade_entrada());
            stmt.setInt(4, produto.getQuantidade_saida());
            stmt.setBigDecimal(5, produto.getPreco());
            stmt.setString(6, produto.getNumero_calcado());
            stmt.setInt(7, produto.getId_produto());
            
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar produto: " + e.getMessage());
            return false;
        }
    }

    // Remove um produto com base no ID
    public boolean excluir(int id_produto) {
        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_produto);

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
            return false;
        }
    }
}
