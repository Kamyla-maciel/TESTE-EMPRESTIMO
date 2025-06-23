package br.com.biblioteca.model;

public class Usuario {
        private int id;
        private String nome;
        private String endereco;
        private int limiteEmprestimos;

        // GETTERS
        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public int getLimiteEmprestimos() {
            return limiteEmprestimos;
        }

        // SETTERS
        public void setId(int id) {
            this.id = id;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public void setLimiteEmprestimos(int limiteEmprestimos) {
            this.limiteEmprestimos = limiteEmprestimos;
        }
    }
