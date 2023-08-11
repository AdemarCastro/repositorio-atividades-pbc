package util;

public class ValidadorCPF implements Validacao{
	@Override
	public void validar(String texto) {
		if (!texto.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
	        throw new RuntimeException("CPF inválido, insira no formato: XXX.XXX.XXX-XX.");
	    }
	}
}
