package teste;

import exceptions.ValidationException;
import model.Cliente;
import model.Dependente;
import model.RelacaoEnum;
import view.DependenteUI;

public class TestaCliente {

  public static void main(String[] args) throws ValidationException {

    /*Cliente cliente1 = new Cliente("Rogerio", "Rua A", "+55 (92) 00000-0000",
        "rogerio@email.com", "000.000.555-33");
    cliente1.addDependente(new Dependente("Filho Um", "Rua D", "+55 (92) 00000-0000",
        "filho01@email.com", "000.000.555-22", RelacaoEnum.valueOf(DependenteUI.formatarTexto("Mãe"))));
    cliente1.addDependente(new Dependente("Filho Dois", "Rua E", "+55 (92) 00000-0000",
        "filho02@email.com", "000.000.555-11", RelacaoEnum.Mae));

    for (Dependente dependente : cliente1.getDependentes()) {
      System.out.println("nome:" + dependente.getNome());
      System.out.println("endereco:" + dependente.getEndereco());
      System.out.println("telefone:" + dependente.getTelefone());
      System.out.println("email:" + dependente.getEmail());
      System.out.println("cpf:" + dependente.getCpf());
      System.out.println("relação:" + dependente.getRelacao());
    }
    */

    Cliente cliente1 = new Cliente("Ademar Castro", "155, Rua Avenida das Flores, Jorge Teixeira, Manaus, AM, 65022-150", "+55 (99) 90000-1111", "ademar.castro@outlook.com", "083.673.900-08", "cpf");

    cliente1.addDependente(new Dependente("Bruna", "233, Rua do Castelo Branco, Coroado, Manaus, AM, 64022-110", "+55 (99) 91111-2222", "bruna.oliveira@outlook.com", "089.731.980-09", "cpf", RelacaoEnum.Filho));

    for (Dependente dependente : cliente1.getDependentes()) {
      System.out.println("nome:" + dependente.getNome());
      System.out.println("endereco:" + dependente.getEndereco());
      System.out.println("telefone:" + dependente.getTelefone());
      System.out.println("email:" + dependente.getEmail());
      System.out.println("cpf:" + dependente.getCpf());
      System.out.println("relação:" + dependente.getRelacao());
    }
  }

}
