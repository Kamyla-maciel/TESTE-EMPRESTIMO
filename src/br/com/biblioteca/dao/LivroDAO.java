package br.com.biblioteca.dao;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public void inserir(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, isbn, disponivel) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.setBoolean(4, livro.isDisponivel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarDisponiveis() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros WHERE disponivel = TRUE";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setDisponivel(rs.getBoolean("disponivel"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    public List<Livro> listarTodos() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setDisponivel(rs.getBoolean("disponivel"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }


    public void marcarComoIndisponivel(int idLivro) {
        String sql = "UPDATE livros SET disponivel = FALSE WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}