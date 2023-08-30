package ifam.pbc.teste;

import ifam.pbc.controller.ClienteController;
import ifam.pbc.model.Cliente;

import java.lang.reflect.*;

import static ifam.pbc.repository.ClienteRepository.procurarNaList;

public class TesteJavaReflection {

    // Exemplo de uso do Java Reflection
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String nomeDoPacote = "ifam.pbc.model";
        String nomeDaClasse = "Cliente";

        String nomeCompletoDaClasse = nomeDoPacote + "." + nomeDaClasse;

        Class<?> classe = Class.forName(nomeCompletoDaClasse);

        // Classe
        System.out.println("Nome da Classe: " + classe.getCanonicalName());

        int modificadoresDaClasse = classe.getModifiers();

        System.out.println("Modificador da Classe: " + Modifier.toString(modificadoresDaClasse));

        // Atributos
        // Obtendo os atributos da classe
        System.out.println("**** ATRIBUTOS ****");

        Field[] atributos = classe.getDeclaredFields();

        for (Field atributo : atributos) {
            // Mostrando os dados de cada atributo
            System.out.print(Modifier.toString(atributo.getModifiers()) + " ");
            System.out.print(atributo.getGenericType().getTypeName() + " ");
            System.out.println(atributo.getName());
        }

        // Obtendo os metodos
        System.out.println("**** METODOS ****");

        Method[] metodos = classe.getDeclaredMethods();

        for (Method metodo : metodos) {
            // Mostrando os dados de cada atributo
            System.out.print(Modifier.toString(metodo.getModifiers()) + " ");
            System.out.print(metodo.getReturnType().getTypeName() + " ");
            System.out.print(metodo.getName());
            System.out.print(" ( ");

            Parameter[] parametros = metodo.getParameters();

            for (Parameter parametro : parametros) {
                System.out.print(parametro.getType().getTypeName() + " ");
                System.out.print(parametro.getName());
            }

            System.out.println(" ) ");

        }

        // Invocação de Métodos

        // Método setId
        // public void setId(int id)

        Class<?>[] parametrosSetId = {int.class};

        Method setId = classe.getMethod("setId", parametrosSetId);

        Object[] valoresSetId = {1};

        // Criar um objeto da classe em tempo de execução

        Object objetoCliente = classe.getDeclaredConstructor().newInstance();

        setId.invoke(objetoCliente, valoresSetId);

        // Método getId
        // public void getId(int id)

        Class<?>[] parametrosGetId = {};

        Method getId = classe.getMethod("getId", parametrosGetId);

        Object[] valoresGetId = {};

        // Método setNome
        // public void setNome(String nome)

        Class<?>[] parametrosSetNome = {String.class};

        Method setNome = classe.getMethod("setNome", parametrosSetNome);

        Object[] valoresSetNome = {"Ademar Castro"};

        setNome.invoke(objetoCliente, valoresSetNome);

        // Método getNome
        // public String getNome()

        Class<?>[] parametrosGetNome = {};

        Method getNome = classe.getMethod("getNome", parametrosGetNome);

        Object[] valoresGetNome = {};

        // Método setEmail
        // public void setEmail(String email)

        Class<?>[] parametrosSetEmail = {String.class};

        Method setEmail = classe.getMethod("setEmail", parametrosSetEmail);

        Object[] valoresSetEmail = {"ademar.castro@outlook.com"};

        setEmail.invoke(objetoCliente, valoresSetEmail);

        // Método getEmail
        // public String getEmail()

        Class<?>[] parametrosGetEmail = {};

        Method getEmail = classe.getMethod("getEmail", parametrosGetEmail);

        Object[] valoresGetEmail = {};

        // Criar um objeto da classe em tempo de execução
        // Usar o mesmo objeto cliente criado anteriormente para conseguir obter o valor do cliente

        // Exibir
        System.out.println("\n");

        Object retornoId = getId.invoke(objetoCliente, valoresGetId);
        System.out.println("ID do Cliente: " + retornoId);

        Object retornoNome = getNome.invoke(objetoCliente, valoresGetNome);
        System.out.println("Nome do Cliente: " + retornoNome);

        Object retornoEmail = getEmail.invoke(objetoCliente, valoresGetEmail);
        System.out.println("Email do Cliente: " + retornoEmail);

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
