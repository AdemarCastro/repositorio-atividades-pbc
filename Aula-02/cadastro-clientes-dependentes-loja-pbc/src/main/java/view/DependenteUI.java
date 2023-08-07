package view;

import java.text.Normalizer;
import java.util.List;
import java.util.Scanner;

import model.Dependente;
import model.RelacaoEnum;
import util.Validacao;

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

        System.out.print("CPF: ");
        String cpf = entrada.nextLine();

        System.out.print("Relação: ");
        String relacao = entrada.nextLine();

        System.out.println("-------------------------------------------");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpf,
                    RelacaoEnum.valueOf(formatarTexto(relacao)));
            return dependente;
        } catch (RuntimeException e) {
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
            System.out.println("    CPF: " + dependente.getCpf());
            System.out.println("    Relação: " + dependente.getRelacao());

            numDependente++;
        }

        System.out.println("-------------------------------------------");
    }

    public static String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }

    public static String formatarTexto(String texto) {
        texto = removerAcentos(texto);

        if (texto.isEmpty()) {
            return texto;
        }

        char primeiraLetra = Character.toUpperCase(texto.charAt(0));
        String restante = texto.substring(1).toLowerCase();

        return primeiraLetra + restante;
    }
}
