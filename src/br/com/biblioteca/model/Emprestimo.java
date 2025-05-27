package br.com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private int idUsuario;
    private int idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    // Construtor
    public Emprestimo(int idUsuario, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    // Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

}