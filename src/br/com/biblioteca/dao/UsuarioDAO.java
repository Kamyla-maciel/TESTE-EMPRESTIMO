package br.com.biblioteca.dao;

import model.Usuario;
import util.Conexao;
import java.sql.*;

public class UsuarioDAO {

        public void inserir(Usuario usuario) {
            String sql = "INSERT INTO usuarios (nome, limite_emprestimos) VALUES (?, ?)";
            try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNome());
                stmt.setInt(2, usuario.getLimiteEmprestimos());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
