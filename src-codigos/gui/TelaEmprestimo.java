package br.com.biblioteca.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

public class TelaEmprestimo extends JFrame {
    private JComboBox<Livro> comboLivros;
    private JComboBox<String> comboUsuarios;
    private JTextField dataEmprestimoField;
    private JTextField dataDevolucaoField;
    private JButton registrarBtn;
    private JButton cadastrarUsuarioBtn;

    public TelaEmprestimo() {
        setTitle("Registrar Empréstimo");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));


        add(new JLabel("Selecione o Livro:"));
        comboLivros = new JComboBox<>();
        LivroDAO livroDAO = new LivroDAO();
        for (Livro livro : livroDAO.listarTodos()) {
            comboLivros.addItem(livro);
        }
        add(comboLivros);


        add(new JLabel("Selecione o Usuário:"));
        comboUsuarios = new JComboBox<>();
        atualizarComboUsuarios();
        add(comboUsuarios);


        cadastrarUsuarioBtn = new JButton("Cadastre-se");
        add(new JLabel());
        add(cadastrarUsuarioBtn);


        add(new JLabel("Data do Empréstimo (YYYY-MM-DD):"));
        dataEmprestimoField = new JTextField();
        add(dataEmprestimoField);

        add(new JLabel("Data Prevista de Devolução (YYYY-MM-DD):"));
        dataDevolucaoField = new JTextField();
        dataDevolucaoField.setEditable(false);
        add(dataDevolucaoField);


        registrarBtn = new JButton("Registrar Empréstimo");
        add(new JLabel());
        add(registrarBtn);


        registrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Livro livroSelecionado = (Livro) comboLivros.getSelectedItem();
                String usuario = (String) comboUsuarios.getSelectedItem();
                String dataEmp = dataEmprestimoField.getText();

                if (livroSelecionado == null || usuario == null || dataEmp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
                    return;
                }

                if (!livroSelecionado.isDisponivel()) {
                    JOptionPane.showMessageDialog(null, "Este livro não está disponível para empréstimo.");
                    return;
                }

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dataEmprestimo = LocalDate.parse(dataEmp, formatter);
                    LocalDate dataDevolucao = dataEmprestimo.plusMonths(3);
                    String dataDevFormatada = dataDevolucao.format(formatter);

                    dataDevolucaoField.setText(dataDevFormatada);

                    JOptionPane.showMessageDialog(null,
                            "Empréstimo registrado:\nLivro: " + livroSelecionado.getTitulo() +
                                    "\nUsuário: " + usuario +
                                    "\nData Empréstimo: " + dataEmp +
                                    "\nData Devolução: " + dataDevFormatada);


                    LivroDAO livroDAO = new LivroDAO();
                    livroDAO.marcarComoIndisponivel(livroSelecionado.getId());


                    livroSelecionado.setDisponivel(false);
                    comboLivros.repaint();

                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida! Use o formato YYYY-MM-DD.");
                }
            }
        });


        cadastrarUsuarioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                br.com.biblioteca.gui.TelaCadastroUsuario cadastro = new br.com.biblioteca.gui.TelaCadastroUsuario(TelaEmprestimo.this);
                cadastro.setVisible(true);

                if (cadastro.isCadastroRealizado()) {
                    atualizarComboUsuarios();
                }
            }
        });

        setVisible(true);
    }

    private void atualizarComboUsuarios() {
        comboUsuarios.removeAllItems();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        for (Usuario usuario : usuarioDAO.listarTodos()) {
            comboUsuarios.addItem(usuario.getNome());
        }
    }