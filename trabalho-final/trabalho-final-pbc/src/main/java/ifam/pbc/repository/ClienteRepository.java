package ifam.pbc.repository;

import ifam.pbc.exception.ClienteJaExistenteException;
import ifam.pbc.exception.ClienteNaoExistenteException;
import ifam.pbc.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<>();

    public static void salvarNaList(Cliente cliente) {
        verificarClienteNaList(cliente);
        clientes.add(cliente);
    }

    public static Cliente procurarNaList(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static void verificarClienteNaList(Cliente cliente) {
        for (Cliente objeto : clientes) {
            if (cliente.getId() == objeto.getId()) {
                throw new ClienteJaExistenteException();
            }
        }
    }

}
