package model;

import exceptions.ValidationException;
import validators.*;

public class Pessoa {

    // Iremos estender essas caracteristicas para Cliente e Pessoa para evitar a
    // redundância

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private String cnpj;

    // Se eu não tiver o construtor padrão não poderei criar apenas um new e depois
    // definir os parametros

    public Pessoa() {

    }

    public Pessoa(String nome, String endereco, String telefone, String email, String id, String tipo) throws ValidationException {
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        setEmail(email);

        if (tipo == "cpf") {
            setCpf(id);
        } else if (tipo == "cnpj") {
            setCnpj(id);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ValidationException {
        NameValidator nameValidator = new NameValidator("Nome", "apenas letras com acentou ou sem e espaços.");
        nameValidator.validate(nome);

        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws ValidationException{
        AddressValidator addressValidator = new AddressValidator("Endereço", "insira no formato: número, rua, bairro, cidade, estado(XX), CEP(XXXXX-XXX).");
        addressValidator.validate(endereco);

        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws ValidationException{
        PhoneValidator phoneValidator = new PhoneValidator("Telefone", "insira no formato: +DD (XX) YXXXX-XXXX.");
        phoneValidator.validate(telefone);

        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ValidationException{
        EmailValidator emailValidator = new EmailValidator("Email", "insira no formato: exemplo@exemplo.com");
        emailValidator.validate(email);

        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ValidationException{
        CPFValidator cpfValidator = new CPFValidator("CPF", "insira um CPF válido e com o formato: XXX.XXX.XXX-XX.");
        cpfValidator.validate(cpf);

        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws ValidationException{
        CNPJValidator cnpjValidator = new CNPJValidator("CNPJ", "insira um CNPJ válido e com o formato: XX.XXX.XXX/XXXX-XX");
        cnpjValidator.validate(cnpj);

        this.cnpj = cnpj;
    }

}
