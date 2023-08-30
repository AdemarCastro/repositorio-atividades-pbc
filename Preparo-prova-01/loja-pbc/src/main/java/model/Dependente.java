package model;

import exceptions.ValidationException;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Dependente extends Pessoa {

    public Dependente() {
        super();
    }

    public Dependente(String nome, String endereco, String telefone, String email, String id, String tipo, RelacaoEnum relacao) throws ValidationException {
        super(nome, endereco, telefone, email, id, tipo);
        this.relacao = relacao;
    }

    private RelacaoEnum relacao;

    public RelacaoEnum getRelacao() {
        return relacao;
    }

    public void setRelacao(RelacaoEnum relacao) {
        this.relacao = relacao;
    }

}
