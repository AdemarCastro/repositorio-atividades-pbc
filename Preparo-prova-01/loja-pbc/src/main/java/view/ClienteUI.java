package view;

import exceptions.ValidationException;
import model.Cliente;

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

        String id = "";
        String tipo = "";

        while (true) {

            System.out.println("\n******* Pessoa Física ou Jurídica? ********");
            System.out.println("  1. Física (CPF)");
            System.out.println("  2. Jurídica (CNPJ)");

            System.out.println("-------------------------------------------");

            System.out.print("  Selecione opção: ");

            try {
                int opcao = entrada.nextInt();
                entrada.nextLine();

                if (opcao == 1) {
                    System.out.println("------------------- CPF -------------------");
                    System.out.print("  CPF: ");
                    id = entrada.nextLine();
                    tipo = "cpf";
                    break;
                } else if (opcao == 2) {
                    System.out.println("------------------ CNPJ -------------------");
                    System.out.print("  CNPJ: ");
                    id = entrada.nextLine();
                    tipo = "cnpj";
                    break;
                } else {
                    System.out.println("Opção inválida: Insira os valores 1 ou 2.");
                }

            } catch (java.util.InputMismatchException e) {
                entrada.nextLine();
                System.out.println("Opção inválida: Insira um valor númerico.");
            }

        }

        System.out.println("-------------------------------------------");

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, id, tipo);
            return cliente;
        } catch (RuntimeException | ValidationException e) {
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

            if (cliente.getCpf() != null) {
                System.out.println("CPF: " + cliente.getCpf());
            } else if (cliente.getCnpj() != null) {
                System.out.println("CNPJ: " + cliente.getCnpj());
            }

            dependenteUI.listar(cliente.getDependentes());

            ultimoCliente = cliente;
            numCliente++;
        }

        if (ultimoCliente.getDependentes() == null) {
            System.out.println("-------------------------------------------");
        }
    }

}
