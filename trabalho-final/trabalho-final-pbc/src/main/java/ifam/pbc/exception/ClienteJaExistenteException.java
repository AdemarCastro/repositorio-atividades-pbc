package ifam.pbc.exception;

public class ClienteJaExistenteException extends RuntimeException{

    public ClienteJaExistenteException() {
        super("Cliente já existe na lista!");
    }
}
