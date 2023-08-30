package validators;

import base.Validator;
import exceptions.ValidationException;
import pbc.base.ILog;
import pbc.exception.LoggerException;

public class EmailValidator extends Validator {

    Class<?> type;

    public EmailValidator(String fieldName, String errorMenssage, ILog logger) throws LoggerException {
        super(logger, fieldName, errorMenssage, String.class);
    }

    public void validate(Object value) throws ValidationException {
        String email = (String) value;

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new ValidationException(getFieldName() + " invalid, enter in this format: exemplo@exemplo.com");
        }

    }

}
