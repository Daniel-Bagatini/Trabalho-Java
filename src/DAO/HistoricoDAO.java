package DAO;

/**
 *
 * @author Daniel
 */
import Vigilancia.Historico;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO implements DAO<Historico> {
    // Banco de dados simulado em memória para os históricos
    private final List<Historico> listHistorico = new ArrayList<>();

    // C - Create (Salvar)
    @Override
    public void salvar(Historico historico) {
        if (historico == null) {
            throw new IllegalArgumentException("Histórico não pode ser nulo.");
        }
        listHistorico.add(historico);
    }

    // R - Read (Buscar todos)
    @Override
    public List<Historico> buscarTodos() {
        return new ArrayList<>(listHistorico);
    }

    // R - Read (Buscar por ID)
    public Historico buscarPorId(int id) {
        if (id < 0) {
            return null;
        }
        for (Historico h : listHistorico) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    @Override
    public Historico buscarPorId(Object identificador) {
        if (identificador == null) {
            return null;
        }
        try {
            int id = Integer.parseInt(identificador.toString().trim());
            return buscarPorId(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Identificador do histórico deve ser um número inteiro válido.");
        }
    }

    // D - Delete (Apagar histórico por ID)
    public boolean deletarPorId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID do histórico não pode ser negativo.");
        }
        Historico h = buscarPorId(id);
        if (h != null) {
            return listHistorico.remove(h);
        }
        return false;
    }
}
