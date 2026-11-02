package ViewSwing;

import DAO.DAO;
import DAO.DatabaseException;
import DAO.DispositivosDAO;
import DAO.HistoricoDAO;
import DAO.PresencialDAO;
import comando.Administrador;
import comando.Usuario;
import Vigilancia.Dispositivos;
import java.util.Scanner;
import Vigilancia.Historico;
import Vigilancia.Presencial;
import Vigilancia.Vigilancia;
import comando.TrataMenu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class MainAlternativa {

    public static void main(String[] args) {

        while (true) {

            String op = JOptionPane.showInputDialog(null, "Escolha seu usuario"
                    + "\n1 - ADMINISTRADOR"
                    + "\n2 - USUARIO EXTERNO"
                    + "\n\n0 ou Cancelar - Retornar");

            //para retornar
            if (op == null || op.equals("0")) {
                JOptionPane.showMessageDialog(null, "Operação cancelada, retornando.");
                return;
            }

            //caso seja apertado enter sem valor
            if (op.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aviso: Você não pode enviar um campo vazio. Tente novamente.");
                continue; // Ignora o código abaixo e volta para o início do while
            }

            int opcao = Integer.parseInt(op);

            switch (opcao) {
                case 1:
                    TrataMenu.setComando(new Administrador());
                    break;
                case 2:
                    TrataMenu.setComando(new Usuario());
                    break;
                default:
                    System.out.println("NAO ENCOTRADO");
            }
        }
    }
}
