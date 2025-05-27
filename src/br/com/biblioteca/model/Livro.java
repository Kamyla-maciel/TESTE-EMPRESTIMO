package br.com.biblioteca.model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    // GETTERS
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return titulo + " - " + (disponivel ? "Disponível" : "Indisponível");
    }
}