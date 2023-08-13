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

        if (!address.matches("\\d+")) {
            throw new ValidationException(getErrorMessage());
        }
    }

}
