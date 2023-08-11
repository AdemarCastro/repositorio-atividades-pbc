package util;

public class ValidadorTelefone implements Validacao{
	@Override
	public void validar(String texto) {
		if (!texto.matches("^\\+\\d{2} \\(\\d{2}\\) \\d{5}-\\d{4}$")) {
            throw new RuntimeException("Telefone inválido, insira no formato: +DD (XX) XXXXX-XXXX.");
        }
	}
}
