package model;

public class Dependente extends Pessoa {

    public Dependente() {
        super();
    }

    public Dependente(String nome, String endereco, String telefone, String email, String cpf, RelacaoEnum relacao) {
        super(nome, endereco, telefone, email, cpf);
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
