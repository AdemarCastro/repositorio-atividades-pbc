package validators;

import base.Validator;
import exceptions.ValidationException;

public class CNPJValidator extends Validator {

    Class<?> type;

    public CNPJValidator(String fieldName, String errorMenssage) { super(fieldName, errorMenssage, String.class); }

    public void validate(Object value) throws ValidationException {
        String cnpj = (String) value;

        // Checking if the CNPJ fits the pattern
        if (!cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/?\\d{4}-\\d{2}")) {
            //System.out.println("CNPJ inválido, insira neste formato: XX.XXX.XXX/XXXX-XX.");
            throw new ValidationException(getFieldName() + " invalid, enter in this format: XX.XXX.XXX/XXXX-XX.");
        }

        // Remove non-numeric characters
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Check if the CNPJ has 14 digits
        if (cnpj.length() != 14) {
            //System.out.println("CNPJ não possui 14 digitos.");
            throw new ValidationException(getFieldName() + " does not have 14 digits.");
        }

        // Check if all digits are the same (invalid CNPJ)
        boolean allDigitsEqual = true;
        for (int i = 1; i < 14; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual) {
            //System.out.println("CNPJ possui todos os digitos iguais.");
            throw new ValidationException(getFieldName() + " has all the digits the same.");
        }

        // Calculate the first check digit
        int sum = 0;
        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        // Check the first check digit
        if (cnpj.charAt(12) - '0' != firstDigit) {
            //System.out.println("Insira um CNPJ válido.");
            throw new ValidationException(getFieldName() + " does not exist.");
        }

        // Calculate the second check digit
        sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit > 9) {
            secondDigit = 0;
        }

        // Check second check digit
        if (cnpj.charAt(12) - '0' != secondDigit) {
            //System.out.println("Insira um CNPJ válido.");
            throw new ValidationException(getFieldName() + " does not exist.");
        }

    }

}
