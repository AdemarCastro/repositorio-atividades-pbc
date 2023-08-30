package ufam.edu.br.listener;

import ufam.edu.br.event.NotaLancadaEvent;

import java.util.EventListener;

public interface NotaLancadaListener extends EventListener {

    void notaLancada(NotaLancadaEvent event);

}
