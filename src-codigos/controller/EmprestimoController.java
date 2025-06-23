package br.com.biblioteca.controller;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.model.Emprestimo;
public class EmprestimoController {
    private EmprestimoDAO dao = new EmprestimoDAO();

    public void registrarEmprestimo(Emprestimo emp) {
        if (dao.livroDisponivel(emp.getIdLivro()) && dao.usuarioPodeEmprestar(emp.getIdUsuario())) {
            dao.inserir(emp);
        } else {
            System.out.println("Empréstimo inválido.");
        }
    }
}