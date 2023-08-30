import exceptions.ValidationException;
import model.Dependente;
import model.RelacaoEnum;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DependenteTest {

    // POSITIVE
    @Order(1)
    @Test
    public void cadastrarDependenteComNomeValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao); // Verificação pelo Componente de Validação

            assertEquals(nome, dependente.getNome()); // Verificação local

            System.out.print("Dependente cadastrado: " + dependente.getNome() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(2)
    @Test
    public void cadastrarDependenteComNomeInvalido() {

        String nome = "4D3M4R C4STR#"; // Nome possui números e caracteres especiais
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(nome, dependente.getNome());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(3)
    @Test
    public void cadastrarDependenteComEnderecoValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertEquals(endereco, dependente.getEndereco());

            System.out.print("Dependente cadastrado: " + dependente.getEndereco() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE

    // Cenário 1: Endereço - Número inválido
    @Order(4)
    @Test
    public void cadastrarDependenteComEnderecoNumeroInvalido() {

        String nome = "Ademar Castro";
        String endereco = "ASD, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65089-150"; // Número não aceita letras, caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(endereco, dependente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 2: Endereço - Rua inválida
    @Order(5)
    @Test
    public void cadastrarDependenteComEnderecoRuaInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, , Jorge Teixeira, Manaus, AM, 65089-150"; // Rua não aceita caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(endereco, dependente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 3: Endereço - Bairro inválido
    @Order(6)
    @Test
    public void cadastrarDependenteComEnderecoBairroInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorg& Te&xeir@, Manaus, AM, 65089-150"; // Bairro não aceita caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(endereco, dependente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 4: Endereço - Cidade inválida
    @Order(7)
    @Test
    public void cadastrarDependenteComEnderecoCidadeInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, M@n@u$, AM, 65089-150"; // Cidade não aceita caracteres especiais e ser deixada em branco
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(endereco, dependente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 5: Endereço - Estado inválido
    @Order(8)
    @Test
    public void cadastrarDependenteComEnderecoEstadoInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, Amazonas, 65089-150"; // Estado aceita apenas 2 letras maiúsculas
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(endereco, dependente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 6: Endereço - CEP inválido
    @Order(9)
    @Test
    public void cadastrarDependenteComEnderecoCEPInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, meu-cep"; // CEP aceita apenas XXXXX-XXX, apenas números.
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(endereco, dependente.getEndereco());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(10)
    @Test
    public void cadastrarDependenteComTelefoneValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertEquals(telefone, dependente.getTelefone());

            System.out.print("Dependente cadastrado: " + dependente.getTelefone() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(11)
    @Test
    public void cadastrarDependenteComTelefoneInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "90000-1111"; // Não possui DD e nem código da região
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(telefone, dependente.getTelefone());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(12)
    @Test
    public void cadastrarDependenteComEmailValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertEquals(email, dependente.getEmail());

            System.out.print("Dependente cadastrado: " + dependente.getEmail() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(13)
    @Test
    public void cadastrarDependenteComEmailInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castrooutlookcom"; // Não possui "@" e nem o "."
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(email, dependente.getEmail());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(14)
    @Test
    public void cadastrarDependenteComCPFValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertEquals(cpfCnpj, dependente.getCpf());

            System.out.print("Dependente cadastrado: " + dependente.getCpf() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE

    // Cenário 1: CPF com formato inválido
    @Order(15)
    @Test
    public void cadastrarDependenteComCPFComFormatoInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "08367390008"; // CPF precisa ter o formato correto XXX.XXX.XXX-XX
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(cpfCnpj, dependente.getCpf());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 2: CPF com não existe
    @Order(16)
    @Test
    public void cadastrarDependenteComCPFInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "000.000.900-08"; // CPF não existe
        String tipoDocumento = "cpf";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(cpfCnpj, dependente.getCpf());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(17)
    @Test
    public void cadastrarDependenteComCNPJValido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "69.231.768/0001-72";
        String tipoDocumento = "cnpj";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertEquals(cpfCnpj, dependente.getCnpj());

            System.out.print("Dependente cadastrado: " + dependente.getCnpj() + "\n");
        } catch (ValidationException e) {
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE

    // Cenário 1: CNPJ com formato inválido
    @Order(18)
    @Test
    public void cadastrarDependenteComCNPJComFormatoInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "69231768000172"; // CNPJ precisa ter o formato correto  XX.XXX.XXX/XXXX-XX
        String tipoDocumento = "cnpj";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(cpfCnpj, dependente.getCnpj());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // Cenário 2: CNPJ com não existe
    @Order(19)
    @Test
    public void cadastrarDependenteComCNPJInvalido() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "00.555.888/0010-66"; // CNPJ não existe
        String tipoDocumento = "cnpj";
        RelacaoEnum relacao = RelacaoEnum.valueOf("Filho");

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, relacao);

            assertNotEquals(cpfCnpj, dependente.getCnpj());

            fail("ValidationException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (ValidationException e) {
            System.out.print("Dependente não cadastrado: " + e.getMessage() + "\n");
        }

    }

    // POSITIVE
    @Order(20)
    @Test
    public void cadastrarDependenteComRelacaoValida() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 69086-150";
        String telefone = "+55 (99) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        String relacaoStr = "Mãe"; // Valor válido

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, RelacaoEnum.valueOf(relacaoStr));

            assertEquals(relacaoStr, dependente.getRelacao().toString());

            System.out.print("Dependente cadastrado: " + dependente.getRelacao() + "\n");
        } catch (IllegalArgumentException | ValidationException e) { // Validator não possui tratamento de exceção para Relação Inválida
            fail(e.getMessage()); // Caso algum dado esteja errado é retornado o motivo aqui
        }

    }

    // NEGATIVE
    @Order(21)
    @Test
    public void cadastrarDependenteComRelacaoInvalida() {

        String nome = "Ademar Castro";
        String endereco = "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150";
        String telefone = "+55 (92) 90000-1111";
        String email = "ademar.castro@outlook.com";
        String cpfCnpj = "083.673.900-08";
        String tipoDocumento = "cpf";
        // Relação primo não está cadastrada na Classe RelacaoEnum
        // Relações cadastradas: Conjunge, Pai, Mãe, Filho, Enteado
        String relacaoStr = "Primo"; // Valor inválido

        try {
            Dependente dependente = new Dependente(nome, endereco, telefone, email, cpfCnpj, tipoDocumento, RelacaoEnum.valueOf(relacaoStr));

            assertNotEquals(relacaoStr, dependente.getRelacao().toString()); // Este é o teste que irá capturar a inconsistência

            fail("IllegalArgumentException esperado, mas nenhuma exceção foi lançada.\n");
        } catch (IllegalArgumentException | ValidationException e) {
            System.out.print("Dependente não cadastrado: " + "Não há o valor " + relacaoStr + " em RelacaoEnum." + "\n");
        }

    }

}
