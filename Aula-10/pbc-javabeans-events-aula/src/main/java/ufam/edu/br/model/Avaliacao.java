package ufam.edu.br.model;

import ufam.edu.br.event.NotaAbaixoDaMediaEvent;
import ufam.edu.br.event.NotaLancadaEvent;
import ufam.edu.br.listener.NotaAbaixoDaMediaListener;
import ufam.edu.br.listener.NotaLancadaListener;
import ufam.edu.br.testes.SMSService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Avaliacao {

    private String titulo;
    private String descricao;
    private Aluno aluno;
    private Double nota;

    // Collections.synchronizedList - Lista Sincronizada: Um acesso por vez. Posso adicionar ou remover um objeto por vez.
    private List<NotaLancadaListener> ouvintes = Collections.synchronizedList(new ArrayList<>());

    private List<NotaAbaixoDaMediaListener> ouvintes2 = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addOuvinte(NotaLancadaListener ouvinte) {
        if(!ouvintes.contains(ouvinte)) ouvintes.add(ouvinte);
    }

    public synchronized void removeOuvinte(NotaLancadaListener ouvinte) {
        if(!ouvintes.contains(ouvinte)) ouvintes.remove(ouvinte);
    }

    public synchronized void addOuvinte2(NotaAbaixoDaMediaListener ouvinte2) {
        if(!ouvintes2.contains(ouvinte2)) ouvintes2.add(ouvinte2);
    }

    public synchronized void removeOuvinte2(NotaAbaixoDaMediaListener ouvinte2) {
        if(!ouvintes2.contains(ouvinte2)) ouvintes2.remove(ouvinte2);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;

        notifyNotaLancada();

        if (nota < 6) {
            notifyNotaAbaixoDaMedia();
        }
    }

    private void notifyNotaLancada() {
        NotaLancadaEvent event = new NotaLancadaEvent(this);

        synchronized (ouvintes) {
            for(NotaLancadaListener ouvinte: ouvintes) ouvinte.notaLancada(event);
        } // Vou proteger essa minha lista contra inconsistências
        // Mais seguro, mas também MAIS LENTO. Importante observar se há a necessidade.
    }

    private void notifyNotaAbaixoDaMedia() {
        NotaAbaixoDaMediaEvent event = new NotaAbaixoDaMediaEvent(this);

        synchronized (ouvintes2) {
            for (NotaAbaixoDaMediaListener ouvinte2: ouvintes2) {
                ouvinte2.notaAbaixoDaMedia(event);
            }
        }

    }

}
