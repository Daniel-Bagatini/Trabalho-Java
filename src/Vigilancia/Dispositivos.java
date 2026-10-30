/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vigilancia;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class Dispositivos extends Vigilancia {
    private String tipoDispositivo;
    private int idDispositivo;
    private boolean ligado;

    public Dispositivos(String tipoDispositivo, int idDispositivo, boolean ligado) {
        this.tipoDispositivo = tipoDispositivo;
        this.idDispositivo = idDispositivo;
        this.ligado = ligado;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        if (tipoDispositivo == null || tipoDispositivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de dispositivo inválido. Não pode ser nulo ou vazio.");
        }
        this.tipoDispositivo = tipoDispositivo;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        if (idDispositivo < 0) {
            throw new IllegalArgumentException("ID do dispositivo invalido. Nao pode ser negativo.");
        }
        this.idDispositivo = idDispositivo;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tipoDispositivo);
        hash = 23 * hash + this.idDispositivo;
        hash = 23 * hash + (this.ligado ? 1 : 0);
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
        final Dispositivos other = (Dispositivos) obj;
        if (this.ligado != other.ligado) {
            return false;
        }
        return Objects.equals(this.tipoDispositivo, other.tipoDispositivo);
    }

    @Override
    public String toString() {
        return "Dispositivos{" + "tipoDispositivo=" + tipoDispositivo + ", idDispositivo=" + idDispositivo + ", ligado=" + ligado + '}';
    }

    // Quase igual ao Presencial
    @Override
    public void alertar(LocalDate data, String local, String descricaoOcorrencia) {
        String ocorrenciaCompleta = descricaoOcorrencia + 
                                    "\nID dispositivo: " + this.idDispositivo +
                                    "\nTipo dispositivo: " + this.tipoDispositivo;

        // Cria o objeto histórico com os dados da Main + os dados locais
        Historico novoHistorico = new Historico(data, local, ocorrenciaCompleta);

        this.setHistorico(novoHistorico); // Salvar na classe mae
    }
}
