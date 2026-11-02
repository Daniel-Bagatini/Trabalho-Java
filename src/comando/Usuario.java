/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comando;

import comando.Comando;
import comando.crud.Read;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Usuario implements Comando {

    @Override
    public void executar() {
        JOptionPane.showMessageDialog(null, "Aviso: O Usuario comum somente pode visualizar");
        TrataMenu.setComando(new Read());
    }

}
