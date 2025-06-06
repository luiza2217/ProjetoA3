package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAO {
   
   // f
   public List<Item_Pedido> buscarPorPedidoId(int idPedido) {
    List<Item_Pedido> itens = new ArrayList<>();
    String sql = "SELECT * FROM item_pedido WHERE id_pedido = ?";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idPedido);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Item_Pedido item = new Item_Pedido(
                rs.getInt("id_item_pedido"),
                rs.getInt("id_produto"),
                rs.getInt("id_pedido"),
                rs.getInt("quantidade")
            );
            itens.add(item);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar itens do pedido: " + e.getMessage());
    }

    return itens;
}
   
   
    // Adiciona um novo item ao pedido
    public boolean adicionar(Item_Pedido item) {
        String sql = "INSERT INTO itempedido (id_produto, id_pedido, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, item.getId_produto());
            stmt.setInt(2, item.getId_pedido());
            stmt.setInt(3, item.getQuantidade());

            int rows = stmt.executeUpdate();

            // Captura o id gerado e define no objeto
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setId_item_pedido(rs.getInt(1));
                }
            }

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar item do pedido: " + e.getMessage());
            return false;
        }
    }

    // Lista todos os itens de pedidos
    public List<Item_Pedido> listar() {
        List<Item_Pedido> itens = new ArrayList<>();
        String sql = "SELECT id_item_pedido, id_produto, id_pedido, quantidade FROM itempedido";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Item_Pedido item = new Item_Pedido(
                    rs.getInt("id_item_pedido"),
                    rs.getInt("id_produto"),
                    rs.getInt("id_pedido"),
                    rs.getInt("quantidade")
                );
                itens.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar itens do pedido: " + e.getMessage());
        }
        return itens;
    }

    // Edita um item do pedido
    public boolean editar(Item_Pedido item) {
        String sql = "UPDATE itempedido SET id_produto = ?, id_pedido = ?, quantidade = ? WHERE id_item_pedido = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getId_produto());
            stmt.setInt(2, item.getId_pedido());
            stmt.setInt(3, item.getQuantidade());
            stmt.setInt(4, item.getId_item_pedido());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar item do pedido: " + e.getMessage());
            return false;
        }
    }

    // Exclui um item do pedido com base no id_item_pedido
    public boolean excluir(int id_item_pedido) {
        String sql = "DELETE FROM itempedido WHERE id_item_pedido = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_item_pedido);

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir item do pedido: " + e.getMessage());
            return false;
        }
    }
}
