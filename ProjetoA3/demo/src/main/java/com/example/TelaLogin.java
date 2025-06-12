package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        campoEmail = new JTextField();
        campoSenha = new JPasswordField();

        add(new JLabel("Email:"));
        add(campoEmail);
        add(new JLabel("Senha:"));
        add(campoSenha);

        JButton botaoLogin = new JButton("Entrar");
        add(new JLabel()); // espaço vazio
        add(botaoLogin);

        botaoLogin.addActionListener(e -> {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = new Usuario(email, senha);
            if (dao.autenticar(u)) {
                dispose();
                new TelaUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "Email ou senha inválidos.");
            }
        });

        setVisible(true);
    }
}
