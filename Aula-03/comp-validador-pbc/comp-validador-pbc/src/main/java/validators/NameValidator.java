package validators;

import base.Validator;
import exceptions.ValidationException;

public class NameValidator extends Validator {

    Class<?> type;
    public NameValidator(String fieldName, String errorMessage) {
        super(fieldName, errorMessage, String.class);
    }

    public void validate(Object value) throws ValidationException {

        String name = (String) value;

        if(!name.matches("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+")){
            throw new ValidationException(getFieldName() + " it should just be unaccented letters, with accent and space.");
        }

    }

}
