package DAO;

/**
 *
 * @author Daniel
 */
import Vigilancia.Dispositivos;
import java.util.ArrayList;
import java.util.List;

public class DispositivosDAO implements DAO<Dispositivos> {
    // Banco de dados simulado em memória para os dispositivos
    private final List<Dispositivos> bancoDispositivos = new ArrayList<>();

    // C - Create (Salvar)
    @Override
    public void salvar(Dispositivos dispositivo) {
        if (dispositivo == null) {
            throw new IllegalArgumentException("Dispositivo não pode ser nulo.");
        }
        bancoDispositivos.add(dispositivo);
    }

    // R - Read (Buscar todos)
    @Override
    public List<Dispositivos> buscarTodos() {
        return new ArrayList<>(bancoDispositivos);
    }

    // R - Read (Buscar por ID do Dispositivo)
    public Dispositivos buscarPorIdDispositivo(int idDispositivo) {
        if (idDispositivo < 0) {
            return null;
        }
        for (Dispositivos d : bancoDispositivos) {
            if (d.getIdDispositivo() == idDispositivo) {
                return d;
            }
        }
        return null; // Retorna null se não encontrar
    }

    @Override
    public Dispositivos buscarPorId(Object identificador) {
        if (identificador == null) {
            return null;
        }
        try {
            int id = Integer.parseInt(identificador.toString().trim());
            return buscarPorIdDispositivo(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Identificador do dispositivo deve ser um número inteiro válido.");
        }
    }

    // D - Delete (Apagar dispositivo do sistema pelo seu ID)
    public boolean deletarPorId(int idDispositivo) {
        if (idDispositivo < 0) {
            throw new IllegalArgumentException("ID do dispositivo não pode ser negativo.");
        }
        Dispositivos d = buscarPorIdDispositivo(idDispositivo);
        if (d != null) {
            return bancoDispositivos.remove(d);
        }
        return false;
    }
}