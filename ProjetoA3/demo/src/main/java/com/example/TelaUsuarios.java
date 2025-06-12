package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaUsuarios extends JFrame {
    private JTextArea area;
    private UsuarioDAO dao;

    public TelaUsuarios() {
        setTitle("Usuários Cadastrados");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout());
        JButton botaoAdicionar = new JButton("Adicionar");
        JButton botaoEditar = new JButton("Editar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoAtualizar = new JButton("Atualizar");
        JButton botaoProdutos = new JButton("Produtos");

        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoAtualizar);
        painelBotoes.add(botaoProdutos);

        add(painelBotoes, BorderLayout.SOUTH);

        dao = new UsuarioDAO();
        atualizarLista();

        botaoAdicionar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Nome:");
            String email = JOptionPane.showInputDialog(this, "Email:");
            String senha = JOptionPane.showInputDialog(this, "Senha:");
            boolean admin = JOptionPane.showConfirmDialog(this, "É administrador?", "Administrador", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            dao.adicionar(new Usuario(0, nome, email, senha, admin));
            atualizarLista();
        });

        botaoEditar.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID do usuário para editar:"));
            String nome = JOptionPane.showInputDialog(this, "Novo nome:");
            String email = JOptionPane.showInputDialog(this, "Novo email:");
            String senha = JOptionPane.showInputDialog(this, "Nova senha:");
            boolean admin = JOptionPane.showConfirmDialog(this, "É administrador?", "Administrador", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            dao.editar(new Usuario(id, nome, email, senha, admin));
            atualizarLista();
        });

        botaoExcluir.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID do usuário para excluir:"));
            dao.excluir(id);
            atualizarLista();
        });

        botaoAtualizar.addActionListener(e -> atualizarLista());

        botaoProdutos.addActionListener(e -> {
            dispose();
            new TelaProdutos();
        });

        setVisible(true);
    }

    private void atualizarLista() {
        List<Usuario> usuarios = dao.listar();
        area.setText("=== Lista de Usuários ===\n");
        for (Usuario u : usuarios) {
            area.append(u.toString() + "\n");
        }
    }
}



