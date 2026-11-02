/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comando;

import comando.Comando;
import comando.TrataMenu;
import comando.crud.Create;
import comando.crud.Delete;
import comando.crud.Read;
import comando.crud.Update;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Administrador implements Comando {

    @Override
    public void executar() {
        System.out.println("Executando adiministrador");
        boolean senhaValida = false;
        String senha = "123";

        do {
            String se = JOptionPane.showInputDialog(null, "Digite a senha");

            //sai do while sem validar a senha
            if (se == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada, etornando.");
                break;
            }

            if (se.equals(senha)) {
                JOptionPane.showMessageDialog(null, "Acesso Concedido! Seja bem-vindo.");
                senhaValida = true; // Sai do laço while
            } else {
                // P
                JOptionPane.showMessageDialog(null, "Senha inválida! Tente novamente.",
                        "Erro de Autenticação",
                        JOptionPane.ERROR_MESSAGE
                );

            }
        } while (senhaValida == false);

        if (senhaValida == true) {

            while (true) {
                String op = JOptionPane.showInputDialog(null, "======ADM======"
                        + "\n1 - Criar"
                        + "\n2 - Ver"
                        + "\n3 - Editar"
                        + "\n4 - Deletar"
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
                        TrataMenu.setComando(new Create());
                        break;
                    case 2:
                        TrataMenu.setComando(new Read());
                        break;
                    case 3:
                        TrataMenu.setComando(new Update());
                        break;
                    case 4:
                        TrataMenu.setComando(new Delete());
                        break;
                    default:
                        System.out.println("NAO ENCOTRADO");
                }
            }
        }
    }

}
