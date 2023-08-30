package repositorio;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {

    // Static: Não preciso estanciar um objeto dessa classe para salvar. Não preciso
    // dar um New para criar um objeto dessa classe.

    // Ao colocar a variável Static eu defino uma variável para toda a aplicação
    // (Classe) e por isso não vai haver a necessidade de usar o This para
    // referenciar um único objeto.
    private static List<Cliente> clientes = new ArrayList<>();

    public static void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    // Não uso mais o THIS: This é uma referencia dinâmica, ele referencia o Objeto,
    // mas agora estou utilizando o escopo da Classe com o Static.
    public static List<Cliente> listar() {
        return clientes;
    }

}
