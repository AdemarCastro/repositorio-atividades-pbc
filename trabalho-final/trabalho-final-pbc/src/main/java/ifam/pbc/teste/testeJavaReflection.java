package ifam.pbc.teste;

import ifam.pbc.controller.ClienteController;
import ifam.pbc.model.Cliente;

import static ifam.pbc.repository.ClienteRepository.procurarNaList;

public class TesteJavaReflection {

    // Exemplo de uso do Java Reflection
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        Cliente cliente = new Cliente(1, "Ademar", "ademar@outlook.com");

        clienteController.exibirInformacoesCliente(cliente);
    }

    // Declaração direta
    /*public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        clienteController.cadastrarCliente(1, "Ademar Castro", "ademar.castro@outlook.com");

        Cliente cliente = procurarNaList(1);
        clienteController.exibirCliente(cliente);
    }*/

    /*
        Às vezes, percebo que usar o Java Reflection pode parecer exagerado. Por exemplo, quando procuro um cliente pelo ID e mostro suas informações, o acesso direto aos campos parece mais simples e claro.

        O Java Reflection é mais útil para lidar com situações complexas, como inspecionar classes em tempo de execução ou lidar com estruturas dinâmicas. Mas, para tarefas simples como essa, o acesso direto funciona bem e é mais fácil de entender.

        Lembre-se de que o uso do Java Reflection pode complicar o código, então, é melhor considerar se realmente é necessário para a situação. No caso de buscar um cliente pelo ID e exibir detalhes, a abordagem direta funciona perfeitamente, sem a necessidade de Reflection.
    */
}
