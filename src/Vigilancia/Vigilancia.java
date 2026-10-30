/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vigilancia;

/**
 *
 * @author 2025001594
 */
public abstract class Vigilancia implements InterfaceAlerta {
    private Historico historico;
    
    // public abstract void alertar(java.time.LocalDate data, String local, String descricaoOcorrencia);
    //inves de chamar aqui o alertar() ele vai ser entregue para as classes filhas
    
    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        if (historico == null) {
            throw new IllegalArgumentException("Histórico não pode ser nulo.");
        }
        this.historico = historico;
    }
}
