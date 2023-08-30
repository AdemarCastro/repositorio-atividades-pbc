package ifam.pbc.controller;

import ifam.pbc.model.Cliente;

import java.lang.reflect.Field;

import static ifam.pbc.repository.ClienteRepository.salvarNaList;

public class ClienteController {

    public void cadastrarCliente(int id, String nome, String email) {
        Cliente cliente = new Cliente(id, nome, email);
        salvarNaList(cliente);
    }

    public void exibirCliente(Cliente cliente) {
        try {
            if (cliente == null) {
                throw new NullPointerException("Cliente é necessário");
            }

            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public void exibirInformacoesCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente é necessário");
            return;
        }

        Class<?> clienteClass = cliente.getClass();
        Field[] fields = clienteClass.getDeclaredFields();

        System.out.println("Informações do Cliente:");
        for (Field field : fields) {
            field.setAccessible(true); // Permite acessar campos privados
            String fieldName = field.getName();
            Object fieldValue;
            try {
                fieldValue = field.get(cliente);
            } catch (IllegalAccessException e) {
                fieldValue = "Não foi possível acessar o valor";
            }
            System.out.println(fieldName + ": " + fieldValue);
        }
    }

}
