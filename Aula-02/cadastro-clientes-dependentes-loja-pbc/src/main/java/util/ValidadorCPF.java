package util;

public class ValidadorCPF implements Validacao{
	@Override
	public void validar(Object value) {

		String cpf = (String) value;

		// Remover caracteres não numéricos
		cpf = cpf.replaceAll("[^0-9]", "");

		// Verificar se o CPF possui 11 dígitos
		if (cpf.length() != 11) {
			System.out.print("!ERRO: CPF não possui 11 digitos.");
		}

		// Verificar se todos os dígitos são iguais (CPF inválido)
		boolean allDigitsEqual = true;
		for (int i = 1; i < 11; i++) {
			if (cpf.charAt(i) != cpf.charAt(0)) {
				allDigitsEqual = false;
				break;
			}
		}
		if (allDigitsEqual) {
			System.out.println("!ERRO: CPF não pode possuir todos os digitos iguais.");
		}

		// Calcular o primeiro dígito verificador
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += (cpf.charAt(i) - '0') * (10 - i);
		}
		int firstDigit = 11 - (sum % 11);
		if (firstDigit >= 10) {
			firstDigit = 0;
		}

		// Verificar o primeiro dígito verificador
		if (cpf.charAt(9) - '0' != firstDigit) {
			System.out.println("!ERRO: Insira um CPF válido.");
		}

		// Calcular o segundo dígito verificador
		sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += (cpf.charAt(i) - '0') * (11 - i);
		}
		int secondDigit = 11 - (sum % 11);
		if (secondDigit >= 10) {
			secondDigit = 0;
		}

		// Verificar o segundo dígito verificador
		if (cpf.charAt(10) - '0' != secondDigit) System.out.println("!ERRO: Insira um CPF válido.");
	}
}
