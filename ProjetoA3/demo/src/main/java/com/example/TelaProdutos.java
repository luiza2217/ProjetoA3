package com.example;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import com.example.TelaPrincipal;


public class TelaProdutos extends JFrame {
    private JTextArea area;
    private ProdutoDAO dao;

    public TelaProdutos() {
        setTitle("Produtos Cadastrados");
        setSize(800, 600);
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
        JButton botaoTelaPrincipal = new JButton("Tela Principal");
        //


        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoAtualizar);
        painelBotoes.add(botaoTelaPrincipal);
       
        
        botaoTelaPrincipal.addActionListener(e -> {
        dispose();
        new TelaPrincipal();
        });

        
        add(painelBotoes, BorderLayout.SOUTH);
        

        dao = new ProdutoDAO();
        atualizarLista();

        botaoAdicionar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Nome do produto:");
            int id_categoria = Integer.parseInt(JOptionPane.showInputDialog(this, "ID da categoria:"));
            int entrada = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade de entrada:"));
            int saida = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade de saída:"));
            BigDecimal preco = new BigDecimal(JOptionPane.showInputDialog(this, "Preço:"));
            String numero_calcado = JOptionPane.showInputDialog(this, "Número do Calçado");
            dao.adicionar(new Produto(0, nome, id_categoria, entrada, saida, preco, numero_calcado));
            atualizarLista();
        });

        botaoEditar.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID do produto para editar:"));
            String nome = JOptionPane.showInputDialog(this, "Novo nome:");
            int id_categoria = Integer.parseInt(JOptionPane.showInputDialog(this, "Novo ID da categoria:"));
            int entrada = Integer.parseInt(JOptionPane.showInputDialog(this, "Nova entrada:"));
            int saida = Integer.parseInt(JOptionPane.showInputDialog(this, "Nova saída:"));
            BigDecimal preco = new BigDecimal(JOptionPane.showInputDialog(this, "Novo preço:"));
            String numero_calcado = JOptionPane.showInputDialog(this, "Novo Número do Calçado");
            dao.editar(new Produto(id, nome, id_categoria, entrada, saida, preco, numero_calcado));
            atualizarLista();
        });

        botaoExcluir.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID do produto para excluir:"));
            dao.excluir(id);
            atualizarLista();
        });

        botaoAtualizar.addActionListener(e -> atualizarLista());

        setVisible(true);
    }

    private void atualizarLista() {
        List<Produto> produtos = dao.listar();
        area.setText("=== Lista de Produtos ===\n");
        for (Produto p : produtos) {
            area.append(p.toString() + "\n");
        }
    }
}






  