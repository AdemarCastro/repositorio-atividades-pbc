package validators;

import base.Validator;
import exceptions.ValidationException;

public class PhoneValidator extends Validator {

    Class<?> type;

    public PhoneValidator(String fieldName, String errorMenssage) {
        super(fieldName, errorMenssage, String.class);
    }

    public void validate(Object value) throws ValidationException {
        String phone = (String) value;

        if (!phone.matches("^\\+\\d{2} \\(\\d{2}\\) \\d{5}-\\d{4}$")) {
            throw new ValidationException(getFieldName() + " invalid, enter in this format: +DD (XX) XXXXX-XXXX.");
        }

    }

}
