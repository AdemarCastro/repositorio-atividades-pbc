package model;

import exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    // Quando eu uso o tipo Texto ou tipo Número:
    // Se eu não vou fazer cálculo com este número é melhor usar o modo texto

    // Lembre-se de puxar o construtor padrão da Super Classe também

    public Cliente() {
        super();
    }

    // Para reutilizar o construtor da Super Classe Pessoa eu preciso referenciar o
    // construtor na classe Cliente
    public Cliente(String nome, String endereco, String telefone, String email, String id, String tipo) throws ValidationException {
        super(nome, endereco, telefone, email, id, tipo);
    }

    // Faltou fazer a relação de Cliente para Dependente

    private List<Dependente> dependentes = new ArrayList<>();

    public void addDependente(Dependente dependente) {
        dependentes.add(dependente);
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }
}
