package view;

import model.Cliente;
import repositorio.ClienteRepositorio;

import java.util.List;
import java.util.Scanner;

public class ClienteUI {

    private DependenteUI dependenteUI = new DependenteUI();

    public Cliente lerDados() {

        Scanner entrada = new Scanner(System.in); // Escaneando a entrada do teclado

        System.out.println("----------------- CLIENTE -----------------");

        System.out.print("Nome: ");
        String nome = entrada.nextLine(); // NextLine ler até eu apertar ENTER

        System.out.print("Endereço: ");
        String endereco = entrada.nextLine();

        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("E-mail: ");
        String email = entrada.nextLine();

        System.out.print("CPF: ");
        String cpf = entrada.nextLine();

        System.out.println("-------------------------------------------");

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpf);
            return cliente;
        } catch (RuntimeException e) {
            System.out.println("ERRO! Não foi possível inserir pessoa: " + e.getMessage());
        }

        return null;
    }

    public void listar(List<Cliente> clientes) {

        int numCliente = 1;
        Cliente ultimoCliente = null;

        for (Cliente cliente : clientes) {
            System.out.println("\n*************** CLIENTE: " + numCliente + " ***************");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf());

            dependenteUI.listar(cliente.getDependentes());

            ultimoCliente = cliente;
            numCliente++;
        }

        if (ultimoCliente.getDependentes() == null) {
            System.out.println("-------------------------------------------");
        }
    }

}
