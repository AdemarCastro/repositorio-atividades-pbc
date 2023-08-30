package validators;

import base.Validator;
import exceptions.ValidationException;
import pbc.base.ILog;
import pbc.exception.LoggerException;

public class CPFValidator extends Validator {

    Class<?> type;

    public CPFValidator(String fieldName, String errorMenssage, ILog logger) throws LoggerException {
        super(logger, fieldName, errorMenssage, String.class);
    }

    public void validate(Object value) throws ValidationException {
        String cpf = (String) value;

        // Checking if the CPF fits the pattern
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            //System.out.print("CPF possuí o formato inválido, insira neste formato: XXX.XXX.XXX-XX.");
            throw new ValidationException(getFieldName() + " invalid, enter in this format: XXX.XXX.XXX-XX.");
        }

        // Remove non-numeric characters
        cpf = cpf.replaceAll("[^0-9]", "");

        // Check if the CPF has 11 digits
        if (cpf.length() != 11) {
            //System.out.print("CPF não possui 11 digitos.");
            throw new ValidationException(getFieldName() + " does not have 11 digits.");
        }

        // Check if all digits are the same (invalid CPF)
        boolean allDigitsEqual = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual) {
            //System.out.print("CPF não pode possuir todos os digitos iguais.");
            throw new ValidationException(getFieldName() + " has all the digits the same.");
        }

        // Calculate the first check digit
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        // Check the first check digit
        if (cpf.charAt(9) - '0' != firstDigit) {
            //System.out.print("Insira um CPF válido.");
            throw new ValidationException(getFieldName() + " does not exist.");
        }

        // Calculate the second check digit
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }

        // Check second check digit
        if (cpf.charAt(10) - '0' != secondDigit) {
            //System.out.println("Insira um CPF válido.");
            throw new ValidationException(getFieldName() + " does not exist.");
        }
    }

}
