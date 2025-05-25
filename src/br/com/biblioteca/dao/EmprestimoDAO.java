package br.com.biblioteca.dao;

import model.Emprestimo;
import util.Conexao;
import java.sql.*;

public class EmprestimoDAO {

        public void inserir(Emprestimo emprestimo) {
            String sql = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, data_devolucao_prevista) VALUES (?, ?, ?, ?)";
            try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, emprestimo.getIdUsuario());
                stmt.setInt(2, emprestimo.getIdLivro());
                stmt.setDate(3, emprestimo.getDataEmprestimo());
                stmt.setDate(4, emprestimo.getDataDevolucaoPrevista());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
