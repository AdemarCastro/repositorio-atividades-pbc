package view;

import java.text.Normalizer;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import exceptions.ValidationException;
import model.Dependente;
import model.RelacaoEnum;

public class DependenteUI {

    public Dependente lerDados() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("---------------- DEPENDENTE ---------------");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

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

        System.out.print("\nRelação: ");
        String relacao = entrada.nextLine();

        System.out.println("-------------------------------------------");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, id, tipo,
                    RelacaoEnum.valueOf(relacao));
            return dependente;
        } catch (RuntimeException | ValidationException e) {
            System.out.println("ERRO! Não foi possível inserir pessoa: " + e.getMessage());
        }

        return null;
    }

    public void listar(List<Dependente> dependentes) {

        int numDependente = 1;

        for (Dependente dependente : dependentes) {
            System.out.println("\n  ************ DEPENDENTE: " + numDependente + " ***********");
            System.out.println("    Nome: " + dependente.getNome());
            System.out.println("    Endereço: " + dependente.getEndereco());
            System.out.println("    Telefone: " + dependente.getTelefone());
            System.out.println("    Email: " + dependente.getEmail());

            if (dependente.getCpf() != null) {
                System.out.println("    CPF: " + dependente.getCpf());
            } else if (dependente.getCnpj() != null) {
                System.out.println("    CNPJ: " + dependente.getCnpj());
            }

            System.out.println("    Relação: " + dependente.getRelacao());

            numDependente++;
        }

        System.out.println("-------------------------------------------");
    }
}
