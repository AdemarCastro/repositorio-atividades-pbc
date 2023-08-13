package base;

import exceptions.ValidationException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Validator {

    private String fieldName;

    private String errorMessage;

    private Class<?> type;
    private Logger logger;


    public Validator(String fieldName, String errorMessage, Class<?> type) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.type = type;

        // Configure the logger
        logger = Logger.getLogger(this.getClass().getName());
        try {
            FileHandler fileHandler = new FileHandler("validation.log", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error setting up logger", e);
        }
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Class<?> getType() {
        return type;
    }

    public abstract void validate(Object value) throws ValidationException;

    private void verifyType(Object value) throws Exception{

        Class<?> objectClassType= value.getClass();

        if(!objectClassType.equals(this.type)){
            throw new ClassCastException("Error on converting types: "
                    +objectClassType.getName()
                    +" into "
                    +this.type.getName());
        }

    }

    public void check(Object value) throws ValidationException{

        try {
            verifyType(value);
            validate(value);
            logger.info("Validation successfull: " + getFieldName());
        }catch(Exception e){
            logger.warning("Validation error: " + getFieldName() + ": " + e.getMessage());
            throw new ValidationException(this.getFieldName() + ": " + this.getErrorMessage(), e);

        }

    }


}
