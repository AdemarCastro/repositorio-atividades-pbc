package validators;

import base.Validator;
import exceptions.ValidationException;
import pbc.base.ILog;
import pbc.exception.LoggerException;

public class AddressValidator extends Validator {

    Class<?> type;

    public AddressValidator(String fieldName, String errorMenssage, ILog logger) throws LoggerException {
        super(logger,
                fieldName,
                errorMenssage,
                String.class);
    }

    public void validate(Object value) throws ValidationException, LoggerException {
        String address = (String) value;
        String[] parts = address.split(", ");

        if (parts.length != 6) {
            try {
                throw new ValidationException(getErrorMessage());
            }catch (ValidationException e) {
                getLogger().log(e);
            }
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
            try {
                throw new ValidationException(getFieldName() + " has invalid number.");
            }catch (ValidationException e) {
                getLogger().log(e);
            }

        }

        // Street validation (part 1)
        if (!street.matches("[\\d,A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")) {
            //System.out.print("Street did not pass!\n");
            try {
                throw new ValidationException(getFieldName() + " has invalid street.");
            }catch (ValidationException e) {
                getLogger().log(e);
            }

        }

        // District validation (part 2)
        if (!district.matches("[\\d,A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")) {
            //System.out.print("District did not pass!\n");
            try {
                throw new ValidationException(getFieldName() + " has invalid district.");
            }catch (ValidationException e) {
                getLogger().log(e);
            }

        }

        // City validation (part 3)
        if (!city.matches("[\\d,A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")) {
            //System.out.print("City did not pass!");
            try {
                throw new ValidationException(getFieldName() + " has invalid city.");
            }catch (ValidationException e) {
                getLogger().log(e);
            }

        }

        // State validation (part 4)
        if (!state.matches("[A-Z]{2}")) {
            //System.out.print("State did not pass!");
            try {
                throw new ValidationException(getFieldName() + " has invalid state.");
            }catch (ValidationException e) {
                getLogger().log(e);
            }

        }

        // CEP validation (part 5)
        if (!zipCode.matches("\\d{5}-\\d{3}")) {
            //System.out.print("ZipCode did not pass!");
            try {
                throw new ValidationException(getFieldName() + " has invalid zip code.");
            }catch (ValidationException e) {
                getLogger().log(e);
            }
        }
    }

}
