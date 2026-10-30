/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Daniel
 */
import Vigilancia.Presencial;
import java.util.ArrayList;
import java.util.List;

public class PresencialDAO implements DAO<Presencial> {
    // Banco de dados simulado em memória para os registros presenciais
    private final List<Presencial> listPresencial = new ArrayList<>();

    // C - Create (Salvar)
    @Override
    public void salvar(Presencial presencial) {
        if (presencial == null) {
            throw new IllegalArgumentException("Registro presencial não pode ser nulo.");
        }
        if (presencial.getPessoa() == null) {
            throw new IllegalArgumentException("Registro presencial deve possuir uma pessoa vinculada.");
        }
        listPresencial.add(presencial);
    }

    // R - Read (Buscar todos)
    @Override
    public List<Presencial> buscarTodos() {
        return new ArrayList<>(listPresencial);
    }

    // R - Read (Buscar pelo CPF da pessoa que está dentro do registro)
    public Presencial buscarPorCpfDoEnvolvido(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        for (Presencial p : listPresencial) {
            if (p.getPessoa() != null && cpf.trim().equals(p.getPessoa().getCPF())) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Presencial buscarPorId(Object identificador) {
        if (identificador == null) {
            return null;
        }
        return buscarPorCpfDoEnvolvido(identificador.toString());
    }

    // D - Delete (Apagar um registro usando o CPF do envolvido)
    public boolean deletarPorCpfDoEnvolvido(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }
        Presencial p = buscarPorCpfDoEnvolvido(cpf);
        if (p != null) {
            return listPresencial.remove(p);
        }
        return false;
    }
}
