package validators;

import base.Validator;
import exceptions.ValidationException;
import pbc.base.ILog;
import pbc.exception.LoggerException;

public class NameValidator extends Validator {

    Class<?> type;
    public NameValidator(String fieldName, String errorMenssage, ILog logger) throws LoggerException {
        super(logger, fieldName, errorMenssage, String.class);
    }

    public void validate(Object value) throws ValidationException {

        String name = (String) value;

        if(!name.matches("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")){
            throw new ValidationException(getFieldName() + " it should just be unaccented letters, with accent and space.");
        }

    }

}
