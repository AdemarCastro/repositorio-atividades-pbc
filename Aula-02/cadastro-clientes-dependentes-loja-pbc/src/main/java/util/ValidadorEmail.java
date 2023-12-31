package util;

public class ValidadorEmail implements Validacao{
	@Override
	public void validar(Object value) {

		String email = (String) value;

		if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new RuntimeException("Email inválido, insira no formato: exemplo@exemplo.com.");
        }
	}
}
