package util;

public class ValidadorTelefone implements Validacao{
	@Override
	public void validar(Object value) {

		String numero = (String) value;

		if (!numero.matches("^\\+\\d{2} \\(\\d{2}\\) \\d{5}-\\d{4}$")) {
            throw new RuntimeException("Telefone inválido, insira no formato: +DD (XX) XXXXX-XXXX.");
        }
	}
}
