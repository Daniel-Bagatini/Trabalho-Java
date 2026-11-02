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
public class Read implements Comando {

    @Override
    public void executar() {
        while (true) {
            String op = JOptionPane.showInputDialog(null, "======Vizualizar Registros======"
                    + "\n1 - Remoto"
                    + "\n2 - Presencial"
                    + "\n3 - Renoto e presencial"
                    + "\n\n0 ou Cancelar - Retornar");

            if (op == null || op.equals("0")) {
                JOptionPane.showMessageDialog(null, "Operação cancelada, retornando.");
                return;
            }

            if (op.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aviso: Você não pode enviar um campo vazio. Tente novamente.");
                continue;
            }

            int opcao = Integer.parseInt(op);

            switch (opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Agr tem que mexer no banco, depois eu faço isso");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Agr tem que mexer no banco, depois eu faço isso");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Agr tem que mexer no banco, depois eu faço isso");

                default:
                    System.out.println("NAO ENCOTRADO");
            }
        }
    }
}
