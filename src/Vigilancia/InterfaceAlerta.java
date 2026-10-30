/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vigilancia;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */

//toda classe que implementar a interface eh obrigatorio usar o alertar
//a classe vigilancia vai usar o implements mas vai passar a obrigatoriedade
//de usar para as classes filhas
public interface InterfaceAlerta {
    void alertar(LocalDate data, String local, String descricaoOcorrencia);
}
