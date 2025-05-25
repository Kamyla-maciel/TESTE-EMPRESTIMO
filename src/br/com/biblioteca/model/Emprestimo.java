package br.com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
        private int id;
        private int idLivro;
        private int idUsuario;
        private LocalDate dataEmprestimo;
        private LocalDate dataPrevistaDevolucao;

        // GETTERS
        public int getId() {
            return id;
        }

        public int getIdLivro() {
            return idLivro;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        public LocalDate getDataPrevistaDevolucao() {
            return dataPrevistaDevolucao;
        }

        // SETTERS
        public void setId(int id) {
            this.id = id;
        }

        public void setIdLivro(int idLivro) {
            this.idLivro = idLivro;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public void setDataEmprestimo(LocalDate dataEmprestimo) {
            this.dataEmprestimo = dataEmprestimo;
        }

        public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
            this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        }
    }
