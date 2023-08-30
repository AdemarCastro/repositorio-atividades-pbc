package ufam.edu.br.testes;

import ufam.edu.br.event.NotaLancadaEvent;
import ufam.edu.br.listener.NotaLancadaListener;
import ufam.edu.br.model.Avaliacao;

public class EmailService implements NotaLancadaListener {

    @Override
    public void notaLancada(NotaLancadaEvent event) {

        Avaliacao avaliacao = (Avaliacao) event.getSource();

        System.out.println("*** Email Enviado ***");
        System.out.println("Aluno: " + avaliacao.getAluno());
        System.out.println("Matricula: " + avaliacao.getAluno().getMatricula());
        System.out.println("Email: " + avaliacao.getAluno().getEmail());
        System.out.println("Nota: " + avaliacao.getNota());
        System.out.println("\n");
    }
}
