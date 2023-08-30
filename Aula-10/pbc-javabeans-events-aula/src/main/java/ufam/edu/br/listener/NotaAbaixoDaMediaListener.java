package ufam.edu.br.listener;

import ufam.edu.br.event.NotaAbaixoDaMediaEvent;

import java.util.EventListener;

public interface NotaAbaixoDaMediaListener extends EventListener {

    void notaAbaixoDaMedia(NotaAbaixoDaMediaEvent event);

}
