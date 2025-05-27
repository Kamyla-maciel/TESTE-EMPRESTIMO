package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.util.Conexao;

public class EmprestimoDAO {

    public void inserir(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, data_devolucao_prevista) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();) {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getIdUsuario());
            stmt.setInt(2, emprestimo.getIdLivro());
            stmt.setDate(3, java.sql.Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, java.sql.Date.valueOf(emprestimo.getDataDevolucaoPrevista()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean livroDisponivel(int idLivro) {
        return true;
    }

    public boolean usuarioPodeEmprestar(int idUsuario) {
        return true;
    }
}