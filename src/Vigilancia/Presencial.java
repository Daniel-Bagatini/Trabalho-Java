/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vigilancia;

import java.util.Objects;

/**
 *
 * @author 2025001594
 */
public class Presencial extends Vigilancia {
    private Pessoa pessoa; // Modificador private adicionado para proteger o encapsulamento
    private String posto;
    
    // Pessoa eh uma composicao do presencial
    public Presencial(String nome, int idade, String CPF, String posto) {
        this.pessoa = new Pessoa(nome, idade, CPF);
        setPosto(posto);
    }

    public Presencial(Pessoa pessoa, String posto) {
        setPessoa(pessoa);
        setPosto(posto);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não pode ser nula.");
        }
        this.pessoa = pessoa;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        if (posto == null || posto.trim().isEmpty()) {
            throw new IllegalArgumentException("Posto inválido. Não pode ser nulo ou vazio.");
        }
        this.posto = posto.trim();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.pessoa);
        hash = 67 * hash + Objects.hashCode(this.posto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Presencial other = (Presencial) obj;
        if (!Objects.equals(this.posto, other.posto)) {
            return false;
        }
        return Objects.equals(this.pessoa, other.pessoa);
    }

    @Override
public String toString() {//##################nao esta mais em uso ####################
    return "--------------------------------------------------\n" +"\nto string presecial" +
           "Posto: " + this.posto + "\n" +
           "Nome do guarda: " + this.pessoa.getNome() + "\n" +
           "(CPF: " + this.pessoa.getCPF() + ")\n" +
           "Idade: " + this.pessoa.getIdade() + " anos\n" +
           "--------------------------------------------------";
}

    @Override
    public void alertar(java.time.LocalDate data, String local, String descricaoOcorrencia) {
        // Monta um texto completo detalhando o ocorrido, o posto e a pessoa
        String ocorrenciaCompleta = descricaoOcorrencia + 
                                    "\nPosto: " + this.posto + 
                                    "\nNome do guarda: " + this.pessoa.getNome() +
                                    "\n(CPF: " + this.pessoa.getCPF() + ")";

        // Cria o objeto histórico com os dados da Main + os dados locais
        Historico novoHistorico = new Historico(data, local, ocorrenciaCompleta);

        this.setHistorico(novoHistorico); // Salvar na classe mae
    } 
}
