package controller;

import java.util.Scanner;

import model.Cliente;

public class HomeController {

    public void executar() {

        ClienteController clienteController = new ClienteController();
        DependenteController dependenteController = new DependenteController();

        Scanner entrada = new Scanner(System.in);

        while (true) {

            System.out.println("\n/////////////////////////////////////////");
            System.out.println("///////////// Menu Principal ////////////");
            System.out.println("/////////////////////////////////////////");

            System.out.println("\n1: Cadastrar Cliente");
            System.out.println("2: Listar Clientes e seus Dependentes");
            System.out.println("3: Sair do Programa");
            System.out.println("-------------------------------------------");
            System.out.print("  Selecione opção: ");

            try {

                int opcao = entrada.nextInt();

                if (opcao == 1) {
                    Cliente cliente = clienteController.cadastrar();

                    if (cliente != null) {
                        while (true) {
                            System.out.println("\n1. Cadastrar Dependente ao Cliente");
                            System.out.println("\n2. Sair");
                            System.out.println("-------------------------------------------");
                            System.out.print("  Selecione opção: ");

                            try {
                                
                                int opcao2 = entrada.nextInt();

                                if (opcao2 == 1) {
                                    dependenteController.cadastrar(cliente);
                                } else if (opcao2 == 2) {
                                    break;
                                } else {
                                    System.out.println("Opção inválida: Insira os valores 1 ou 2.");
                                }

                            } catch (java.util.InputMismatchException e) {
                                entrada.nextLine();
                                System.out.println("Opção inválida: Insira um valor númerico.");
                            }
                        }
                    }
                } else if (opcao == 2) {
                    clienteController.listar();
                } else if (opcao == 3) {
                    break;
                } else {
                    System.out.println("Opção inválida: Insira os valores 1, 2 ou 3.");
                }

            } catch (java.util.InputMismatchException e) {
                entrada.nextLine();
                System.out.println("Opção inválida: Insira um valor númerico.");
            }

        }

    }

}
