package ufam.edu.br.testes;

import ufam.edu.br.model.Aluno;
import ufam.edu.br.model.Avaliacao;

public class TesteEnviaAvaliacaoPorEmail {

    public static void main(String[] args) {

        Avaliacao avaliacao = new Avaliacao();
        Avaliacao avaliacao2 = new Avaliacao();

        avaliacao.setAluno(new Aluno("Ademar", "1234567899", "(92) 90000-1515","ademar@ufam.edu.br"));
        avaliacao2.setAluno(new Aluno("Lucas", "1234567800", "(92) 90000-1212","lucas@ufam.edu.br"));

        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();

        avaliacao.addOuvinte(emailService);
        avaliacao2.addOuvinte2(smsService);

        avaliacao.setNota(9.0);
        avaliacao2.setNota(5.0);

    }

}
