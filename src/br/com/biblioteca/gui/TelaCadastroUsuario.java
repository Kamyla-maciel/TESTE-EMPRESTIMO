package br.com.biblioteca.gui;

import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroUsuario extends JDialog {
    private JTextField nomeField;
    private JTextField enderecoField;
    private JTextField limiteEmprestimosField;
    private JButton salvarBtn;
    private boolean cadastroRealizado = false;

    public TelaCadastroUsuario(JFrame parent) {
        super(parent, "Cadastro de Usuário", true);
        setSize(400, 250);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        add(enderecoField);

        add(new JLabel("Limite de Empréstimos:"));
        limiteEmprestimosField = new JTextField("3");
        add(limiteEmprestimosField);

        salvarBtn = new JButton("Salvar");
        add(new JLabel());
        add(salvarBtn);

        salvarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText().trim();
                String endereco = enderecoField.getText().trim();
                int limite;

                try {
                    limite = Integer.parseInt(limiteEmprestimosField.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Informe um número válido para limite de empréstimos.");
                    return;
                }

                if (nome.isEmpty() || endereco.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    return;
                }

                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setEndereco(endereco);
                usuario.setLimiteEmprestimos(limite);

                UsuarioDAO dao = new UsuarioDAO();
                dao.inserir(usuario);

                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                cadastroRealizado = true;
                dispose();
            }
        });
    }

    public boolean isCadastroRealizado() {
        return cadastroRealizado;
    }
}