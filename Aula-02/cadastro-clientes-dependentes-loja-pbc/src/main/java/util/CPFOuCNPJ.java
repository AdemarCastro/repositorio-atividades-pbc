package util;

public class CPFOuCNPJ {

    public String cpfOuCnpj(String id) {

        if (id.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return "cpf";
        } else if (id.matches("\\d{2}\\.\\d{3}\\.\\d{3}/?\\d{4}-\\d{2}")) {
            return "cnpj";
        } else {
            throw new RuntimeException("Valor inválido, insira no formato: XXX.XXX.XXX-XX para CPF ou XX.XXX.XXX/XXXX-XX para CNPJ.");
        }
    }
}
