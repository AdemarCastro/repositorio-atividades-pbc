package ifam.pbc.exception;

public class ClienteNaoExistenteException extends RuntimeException{
    public ClienteNaoExistenteException() {
        super("Cliente não existe no Banco de Dados!");
    }

}
