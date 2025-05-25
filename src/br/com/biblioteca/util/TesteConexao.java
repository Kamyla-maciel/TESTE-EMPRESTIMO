package br.com.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca"; // seu banco
        String usuario = "root"; // seu usuário do MySQL
        String senha = "rafaelTB07#"; // sua senha do MySQL

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados:");
            e.printStackTrace();
        }
    }
}