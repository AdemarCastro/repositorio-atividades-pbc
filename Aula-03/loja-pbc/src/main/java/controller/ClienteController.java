package controller;

import model.Cliente;
import repositorio.ClienteRepositorio;
import view.ClienteUI;

public class ClienteController {

    // Isso fica vivo enquanto tiver o Objeto de Controller no ar, o que eu poderia
    // fazer para guardar a referencia mesmo que eu não tenha essa variável aqui.
    // Solução: Deixar a Classe Static
    // private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

    private ClienteUI clienteUI = new ClienteUI();

    public Cliente cadastrar() {

        // Irei utilizar apenas os métodos da ClienteUI, então não há a necessidade de
        // colocá-la no escopo global. Ás vezes algumas variáveis tem um custo muito
        // grande para aplicação e não vale a pena deixá-la no escopo global.
        // ClienteUI clienteUI = new ClienteUI();

        Cliente cliente = clienteUI.lerDados();

        if (cliente != null) {
            ClienteRepositorio.salvar(cliente);
        }

        return cliente; // Estou retornando o Cliente para que possa recuperá-lo ao cadastrar o
                        // Dependente

    }

    // Controller é meio que um orquestrador para montar as demandas e fornecer, não
    // é legal deixar a parte de exibição no Controller
    public void listar() {

        clienteUI.listar(ClienteRepositorio.listar());

    }

}
