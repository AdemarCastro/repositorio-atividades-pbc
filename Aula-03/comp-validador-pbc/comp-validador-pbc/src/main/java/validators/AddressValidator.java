package validators;

import base.Validator;
import exceptions.ValidationException;

public class AddressValidator extends Validator {

    Class<?> type;

    public AddressValidator(String fieldName, String errorMenssage) {
        super(fieldName, errorMenssage, String.class);
    }

    public void validate(Object value) throws ValidationException {
        String address = (String) value;
        String[] parts = address.split(", ");

        if (parts.length != 6) {
            throw new ValidationException(getErrorMessage());
        }

        String number = parts[0];
        String street = parts[1];
        String district = parts[2];
        String city = parts[3];
        String state = parts[4];
        String zipCode = parts[5];

        // Number validation (part 0)
        if (!number.matches("\\d+")) {
            //System.out.print("Number did not pass!");
            throw new ValidationException(getFieldName() + " has invalid number.");
        }

        // Street validation (part 1)
        if (!street.matches("[\\d,A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")) {
            //System.out.print("Street did not pass!\n");
            throw new ValidationException(getFieldName() + " has invalid street.");
        }

        // District validation (part 2)
        if (!district.matches("[\\d,A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")) {
            //System.out.print("District did not pass!\n");
            throw new ValidationException(getFieldName() + " has invalid district.");
        }

        // City validation (part 3)
        if (!city.matches("[\\d,A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")) {
            //System.out.print("City did not pass!");
            throw new ValidationException(getFieldName() + " has invalid city.");
        }

        // State validation (part 4)
        if (!state.matches("[A-Z]{2}")) {
            //System.out.print("State did not pass!");
            throw new ValidationException(getFieldName() + " has invalid state.");
        }

        // CEP validation (part 5)
        if (!zipCode.matches("\\d{5}-\\d{3}")) {
            //System.out.print("ZipCode did not pass!");
            throw new ValidationException(getFieldName() + " has invalid zip code.");
        }
    }

}
