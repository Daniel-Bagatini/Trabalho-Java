/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comando.crud;

import comando.Comando;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class CreatePresencial implements Comando {

    @Override
    public void executar() {
        while (true) {
           JOptionPane.showMessageDialog(null, "Agr tem que mexer no banco, depois eu faço isso");
            return;
        }
    }

}