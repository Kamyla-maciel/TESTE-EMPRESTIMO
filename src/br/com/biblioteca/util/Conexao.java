package br.com.biblioteca.util;

public class Conexao {

    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "rafaelTB07#";

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}