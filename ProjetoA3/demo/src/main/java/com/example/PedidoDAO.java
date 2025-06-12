package com.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class PedidoDAO {

//ff


   
    // Adiciona um novo pedido
    public boolean adicionar(Pedido pedido) {
        String sql = "INSERT INTO Pedido (total_pedido, status, data, id_usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setBigDecimal(1, pedido.getTotal_pedido());
            stmt.setString(2, pedido.getStatus());
            stmt.setDate(3, Date.valueOf(pedido.getData())); // Converte LocalDate para java.sql.Date
            stmt.setInt(4, pedido.getId_usuario());

            int rows = stmt.executeUpdate();

            // Captura o ID gerado pelo banco e define no objeto
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pedido.setId_pedido(rs.getInt(1));
                }
            }

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pedido: " + e.getMessage());
            return false;
        }
    }

    // Lista todos os pedidos
    public List<Pedido> listar() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id_pedido, total_pedido, status, data, id_usuario FROM Pedido";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getBigDecimal("total_pedido"),
                    rs.getString("status"),
                    rs.getDate("data").toLocalDate(), // Converte java.sql.Date para LocalDate
                    rs.getInt("id_usuario")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pedidos: " + e.getMessage());
        }

        return pedidos;
    }

    // Edita pedido existente
    public boolean editar(Pedido pedido) {
        String sql = "UPDATE Pedido SET total_pedido = ?, status = ?, data = ?, id_usuario = ? WHERE id_pedido = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBigDecimal(1, pedido.getTotal_pedido());
            stmt.setString(2, pedido.getStatus());
            stmt.setDate(3, Date.valueOf(pedido.getData()));
            stmt.setInt(4, pedido.getId_usuario());
            stmt.setInt(5, pedido.getId_pedido());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar pedido: " + e.getMessage());
            return false;
        }
    }

    // Remove pedido por ID
    public boolean excluir(int id_pedido) {
        String sql = "DELETE FROM Pedido WHERE id_pedido = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_pedido);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pedido: " + e.getMessage());
            return false;
        }
    }
}
