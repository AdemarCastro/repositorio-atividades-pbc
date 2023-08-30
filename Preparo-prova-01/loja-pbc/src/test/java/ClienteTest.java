import exceptions.ValidationException;
import model.Cliente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteTest {

    // POSITIVE
    @Order(1)
    @Test
    public void cadastrarClienteComNomeValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento); // Verificação pelo Componente de Validação

            assertEquals(nome, cliente.getNome()); // Verificação local

            System.out.print("Cliente cadastrado: " + cliente.getNome() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(2)
    @Test
    public void cadastrarClienteComNomeInvalido() {

        String nome = "4D3M4R C4STR#"; // Nome possui números e caracteres especiais
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(nome, cliente.getNome());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(3)
    @Test
    public void cadastrarClienteComEnderecoValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertEquals(endereco, cliente.getEndereco());

            System.out.print("Cliente cadastrado: " + cliente.getEndereco() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE

    // Cenário 1: Endereço - Número inválido
    @Order(4)
    @Test
    public void cadastrarClienteComEnderecoNumeroInvalido() {

        String nome = "Ademar Castro";
        String endereco = "ASD, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65089-150"; // Número não aceita letras, caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(endereco, cliente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 2: Endereço - Rua inválida
    @Order(5)
    @Test
    public void cadastrarClienteComEnderecoRuaInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, , Jorge Teixeira, Manaus, AM, 65089-150"; // Rua não aceita caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(endereco, cliente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 3: Endereço - Bairro inválido
    @Order(6)
    @Test
    public void cadastrarClienteComEnderecoBairroInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorg& Te&xeir@, Manaus, AM, 65089-150"; // Bairro não aceita caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(endereco, cliente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 4: Endereço - Cidade inválida
    @Order(7)
    @Test
    public void cadastrarClienteComEnderecoCidadeInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, M@n@u$, AM, 65089-150"; // Cidade não aceita caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(endereco, cliente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 5: Endereço - Estado inválido
    @Order(8)
    @Test
    public void cadastrarClienteComEnderecoEstadoInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, Amazonas, 65089-150"; // Estado aceita apenas 2 letras maiúsculas
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(endereco, cliente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 6: Endereço - CEP inválido
    @Order(9)
    @Test
    public void cadastrarClienteComEnderecoCEPInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, meu-cep"; // CEP aceita apenas XXXXX-XXX, apenas números.
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(endereco, cliente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(10)
    @Test
    public void cadastrarClienteComTelefoneValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertEquals(telefone, cliente.getTelefone());

            System.out.print("Cliente cadastrado: " + cliente.getTelefone() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(11)
    @Test
    public void cadastrarClienteComTelefoneInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "90000-1111"; // Não possui DD e nem código da região
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(telefone, cliente.getTelefone());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(12)
    @Test
    public void cadastrarClienteComEmailValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertEquals(email, cliente.getEmail());

            System.out.print("Cliente cadastrado: " + cliente.getEmail() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(13)
    @Test
    public void cadastrarClienteComEmailInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castrooutlookcom"; // Não possui "@" e nem o "."
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(email, cliente.getEmail());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(14)
    @Test
    public void cadastrarClienteComCPFValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertEquals(cpfCnpj, cliente.getCpf());

            System.out.print("Cliente cadastrado: " + cliente.getCpf() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE

    // Cenário 1: CPF com formato inválido
    @Order(15)
    @Test
    public void cadastrarClienteComCPFComFormatoInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "08367390008"; // CPF precisa ter o formato correto XXX.XXX.XXX-XX
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(cpfCnpj, cliente.getCpf());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 2: CPF com não existe
    @Order(16)
    @Test
    public void cadastrarClienteComCPFInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "000.000.900-08"; // CPF não existe
        String tipoDocumento = "cpf";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(cpfCnpj, cliente.getCpf());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(17)
    @Test
    public void cadastrarClienteComCNPJValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "69.231.768/0001-72";
        String tipoDocumento = "cnpj";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertEquals(cpfCnpj, cliente.getCnpj());

            System.out.print("Cliente cadastrado: " + cliente.getCnpj() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE

    // Cenário 1: CNPJ com formato inválido
    @Order(18)
    @Test
    public void cadastrarClienteComCNPJComFormatoInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "69231768000172"; // CNPJ precisa ter o formato correto  XX.XXX.XXX/XXXX-XX
        String tipoDocumento = "cnpj";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(cpfCnpj, cliente.getCnpj());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 2: CNPJ com não existe
    @Order(19)
    @Test
    public void cadastrarClienteComCNPJInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "00.555.888/0010-66"; // CNPJ não existe
        String tipoDocumento = "cnpj";

        try {
            Cliente cliente = new Cliente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento);

            assertNotEquals(cpfCnpj, cliente.getCnpj());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Cliente não cadastrado: " + e.getMessage() + "\n");
        }

    }

}
