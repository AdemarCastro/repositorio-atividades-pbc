package ufam.edu.br.event;

import java.util.EventObject;

public class NotaAbaixoDaMediaEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public NotaAbaixoDaMediaEvent(Object source) {
        super(source);
    }
}
