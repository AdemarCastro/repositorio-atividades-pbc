package validators;

import base.Validator;
import exceptions.ValidationException;
import pbc.base.ILog;
import pbc.exception.LoggerException;

public class PhoneValidator extends Validator {

    Class<?> type;

    public PhoneValidator(String fieldName, String errorMenssage, ILog logger) throws LoggerException {
        super(logger, fieldName, errorMenssage, String.class);
    }

    public void validate(Object value) throws ValidationException {
        String phone = (String) value;

        if (!phone.matches("^\\+\\d{2} \\(\\d{2}\\) \\d{5}-\\d{4}$")) {
            throw new ValidationException(getFieldName() + " invalid, enter in this format: +DD (XX) XXXXX-XXXX.");
        }

    }

}
