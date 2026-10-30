/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vigilancia;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author 2025001594
 */
public class Historico {
    private int id;
    private LocalDate data;
    private String local;
    private String ocorrencia;

    private static int contadorId = 0;

    public Historico(LocalDate data, String local, String ocorrencia) {
        this.id = contadorId++;
        this.data = data;
        this.local = local;
        this.ocorrencia = ocorrencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID do historico não pode ser negativo.");
        }
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data nao pode ser nula.");
        }
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        if (local == null || local.trim().isEmpty()) {
            throw new IllegalArgumentException("Local invalido. Nao pode ser nulo ou vazio.");
        }
        this.local = local.trim();
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        if (ocorrencia == null || ocorrencia.trim().isEmpty()) {
            throw new IllegalArgumentException("Ocorrência invalida. Nao pode ser nula ou vazia.");
        }
        this.ocorrencia = ocorrencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.data);
        hash = 89 * hash + Objects.hashCode(this.local);
        hash = 89 * hash + Objects.hashCode(this.ocorrencia);
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
        final Historico other = (Historico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.ocorrencia, other.ocorrencia)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "Historico ID: " + this.id + "\n" +
               "Data: " + this.data + " - " + this.getDiaSemana() + "\n" +
               "Local: " + this.local + "\n" +
               "Ocorrencia: " + this.ocorrencia + "\n";
    }

    public diaSemana getDiaSemana() {
        if (this.data == null) {
            return null;
        }
        // Pega o DayOfWeek do Java e joga no método 'de' do enum
        return diaSemana.de(this.data.getDayOfWeek());
    }
}
