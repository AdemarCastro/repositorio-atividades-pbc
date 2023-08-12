package controller;

import model.Cliente;
import model.Dependente;
import view.ClienteUI;
import view.DependenteUI;

public class DependenteController {

    private DependenteUI dependenteUI = new DependenteUI();
    private ClienteUI clienteUI = new ClienteUI();

    public void cadastrar(Cliente cliente) {

        if (cliente != null) {

            Dependente dependente = dependenteUI.lerDados();

            if (dependente != null) {
                cliente.addDependente(dependente);
            }

        }

    }

    public void listar() {

        Cliente cliente = clienteUI.lerDados();

        cliente.getDependentes();

    }

}
