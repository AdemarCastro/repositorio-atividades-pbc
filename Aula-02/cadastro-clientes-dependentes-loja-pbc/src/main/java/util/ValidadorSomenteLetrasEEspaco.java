package util;

public class ValidadorSomenteLetrasEEspaco implements Validacao{
	@Override
	public void validar(String texto) {
		if (!texto.matches("[a-zA-Z\\s]+")) {
			throw new RuntimeException("Nome ou Endereço inválidos: Somente pode conter letras e espaço.");
		}
	}
}
