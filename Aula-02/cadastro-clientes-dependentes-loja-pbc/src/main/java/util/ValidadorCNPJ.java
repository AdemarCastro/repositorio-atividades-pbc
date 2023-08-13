package util;

public class ValidadorCNPJ {

    public void validar(Object value) {

        String cnpj = (String) value;

        System.out.println(cnpj);

        cnpj = cnpj.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos

        System.out.println(cnpj);

        // Verificar se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            System.out.println("!ERRO: CNPJ não possui 14 digitos.");
        }

        // Verificar se todos os dígitos são iguais (CNPJ inválido)
        boolean allDigitsEqual = true;
        for (int i = 1; i < 14; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual) {
            System.out.println("!ERRO: CNPJ possui todos os digitos iguais.");
        }

        // Calcular o primeiro dígito verificador
        int sum = 0;
        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        // Verificar o primeiro digito verificador
        if (cnpj.charAt(12) - '0' != firstDigit) {
            System.out.println("!ERRO: Insira um CNPJ válido.");
        }

        // Calcular o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }

        // Verificar o segundo dígito verificador
        if (cnpj.charAt(13) - '0' != secondDigit) System.out.println("!ERRO: Insira um CNPJ válido.");
    }

}
