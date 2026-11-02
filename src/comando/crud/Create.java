/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comando.crud;

import comando.Comando;
import comando.crud.CreateRemoto;
import comando.TrataMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Create implements Comando {

    @Override
    public void executar() {

        while (true) {
            String op = JOptionPane.showInputDialog(null, "Tipo de regitro de ocorrencia"
                    + "\n1 - Remota"
                    + "\n2 - Presencial"
                    + "\n\n0 ou Cancelar - Retornar");

            if (op == null || op.equals("0")) {
                JOptionPane.showMessageDialog(null, "Operação cancelada, retornando.");
                return;
            }

            if (op.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aviso: Você não pode enviar um campo vazio. Tente novamente.");
                continue; // Ignora o código abaixo e volta para o início do while
            }
            int opcao = Integer.parseInt(op);

            
            
            switch (opcao) {
                
                case 1:
                    TrataMenu.setComando(new CreateRemoto());
                    break;
                case 2:
                    TrataMenu.setComando(new CreatePresencial());
                    break;
                default:
                    System.out.println("NAO ENCOTRADO");
            }
        }
    }
}
