package model;

import util.ValidadorCPF;
import util.ValidadorEmail;
import util.ValidadorSomenteLetrasEEspacoComAcentos;
import util.ValidadorTelefone;

public class Pessoa {

    // Iremos estender essas caracteristicas para Cliente e Pessoa para evitar a
    // redundância

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    // Se eu não tiver o construtor padrão não poderei cliar apenas um new e depois
    // definir os parametros

    public Pessoa() {

    }

    public Pessoa(String nome, String endereco, String telefone, String email, String id) {
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        setEmail(email);
        setCpfOuCNPJ(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        new ValidadorSomenteLetrasEEspacoComAcentos().validar(nome);
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
    	new ValidadorSomenteLetrasEEspacoComAcentos().validar(endereco);
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        new ValidadorTelefone().validar(telefone);
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        new ValidadorEmail().validar(email);
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
    	new ValidadorCPF().validar(cpf);
        this.cpf = cpf;
    }

}
