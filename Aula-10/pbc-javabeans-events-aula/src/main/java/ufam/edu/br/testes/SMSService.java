package ufam.edu.br.testes;

import ufam.edu.br.event.NotaAbaixoDaMediaEvent;
import ufam.edu.br.event.NotaLancadaEvent;
import ufam.edu.br.listener.NotaAbaixoDaMediaListener;
import ufam.edu.br.listener.NotaLancadaListener;
import ufam.edu.br.model.Avaliacao;

public class SMSService implements NotaAbaixoDaMediaListener {

    @Override
    public void notaAbaixoDaMedia(NotaAbaixoDaMediaEvent event) {

        Avaliacao avaliacao = (Avaliacao) event.getSource();

        System.out.println("*** SMS Enviado ***");
        System.out.println("Aluno: " + avaliacao.getAluno());
        System.out.println("Matricula: " + avaliacao.getAluno().getMatricula());
        System.out.println("Telefone: " + avaliacao.getAluno().getTelefone());
        System.out.println("Email: " + avaliacao.getAluno().getEmail());
        System.out.println("Nota: " + avaliacao.getNota());
        System.out.println("\n");
    }
}
