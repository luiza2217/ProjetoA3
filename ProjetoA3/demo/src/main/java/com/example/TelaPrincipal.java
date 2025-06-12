package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.time.format.DateTimeFormatter;
import com.example.PedidoDAO;
import com.example.Pedido;

public class TelaPrincipal extends JFrame {

    private JTextArea area;
    private PedidoDAO pedidoDAO;

    public TelaPrincipal() {
        setTitle("Pedidos Realizados");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar para Produtos");
        voltar.addActionListener(e -> {
            dispose();
            TelaProdutos telaProdutos = new TelaProdutos(); // assume que TelaProdutos já existe
            telaProdutos.setVisible(true);
        });

        add(voltar, BorderLayout.SOUTH);

        pedidoDAO = new PedidoDAO();

        mostrarPedidos();
        setVisible(true);
    }

    private void mostrarPedidos() {
        List<Pedido> pedidos = pedidoDAO.listar();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (pedidos.isEmpty()) {
            area.setText("Nenhum pedido encontrado.");
            return;
        }

        area.setText("=== PEDIDOS ===\n\n");

        for (Pedido pedido : pedidos) {
            area.append("ID Pedido: " + pedido.getId_pedido() + "\n");
            area.append("ID Usuário: " + pedido.getId_usuario() + "\n");
            area.append("Data: " + pedido.getData().format(formatter) + "\n");
            area.append("Status: " + pedido.getStatus() + "\n");
            area.append("Valor Total: R$ " + pedido.getTotal_pedido() + "\n");
            area.append("-------------------------------\n");
        }
    }
}
