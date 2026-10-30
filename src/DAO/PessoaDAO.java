/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Daniel
 */
import Vigilancia.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements DAO<Pessoa> {
    // Simulando uma tabela/banco de dados em memória utilizando ArrayList
    private final List<Pessoa> listPessoas = new ArrayList<>();

    // C - Create (Salvar uma nova pessoa)
    @Override
    public void salvar(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não pode ser nula.");
        }
        if (buscarPorCPF(pessoa.getCPF()) != null) {
            throw new DatabaseException("Ja existe uma pessoa cadastrada com o CPF: " + pessoa.getCPF());
        }
        listPessoas.add(pessoa);
    }

    // R - Read (Buscar todas as pessoas)
    @Override
    public List<Pessoa> buscarTodos() {
        return new ArrayList<>(listPessoas); // Retorna uma cópia para proteger a lista original
    }

    // Mantido para compatibilidade com chamadas anteriores
    public List<Pessoa> buscarTodas() {
        return buscarTodos();
    }

    // R - Read (Buscar uma pessoa específica pelo CPF)
    public Pessoa buscarPorCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        for (Pessoa p : listPessoas) {
            if (p.getCPF().equals(cpf.trim())) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar
    }

    @Override
    public Pessoa buscarPorId(Object identificador) {
        if (identificador == null) {
            return null;
        }
        return buscarPorCPF(identificador.toString());
    }

    // U - Update (Atualizar os dados de uma pessoa)
    public boolean atualizar(String cpfOriginal, Pessoa pessoaAtualizada) {
        if (cpfOriginal == null || cpfOriginal.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF para atualização não pode ser nulo ou vazio.");
        }
        if (pessoaAtualizada == null) {
            throw new IllegalArgumentException("Dados da pessoa atualizada não podem ser nulos.");
        }
        Pessoa pessoaExistente = buscarPorCPF(cpfOriginal);
        if (pessoaExistente == null) {
            throw new DatabaseException("Pessoa com CPF " + cpfOriginal + " não encontrada para atualização.");
        }
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setIdade(pessoaAtualizada.getIdade());
        pessoaExistente.setCPF(pessoaAtualizada.getCPF());
        return true;
    }

    // D - Delete (Apagar uma pessoa do sistema pelo CPF)
    public boolean deletar(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }
        Pessoa p = buscarPorCPF(cpf);
        if (p != null) {
            listPessoas.remove(p);
            return true;
        }
        return false;
    }
}
