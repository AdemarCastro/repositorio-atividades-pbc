package base;

import exceptions.ValidationException;
import pbc.base.ILog;
import pbc.exception.LoggerException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public abstract class Validator {

    private String fieldName;

    private String errorMessage;

    private Class<?> type;

    private final ILog logger;

    public ILog getLogger() {
        return logger;
    }

    public Validator(ILog logger, String fieldName, String errorMessage, Class<?> type) throws LoggerException {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.type = type;
        this.logger = logger;

        logger.setSource("logs\\validator"+"-"+fieldName);
        // Criar a pasta "logs" na raiz do projeto, caso não exista
        createLogsDirectory();
    }

    private void createLogsDirectory() {
        Path logsPath = Paths.get("logs");
        if (!Files.exists(logsPath)) {
            try {
                Files.createDirectory(logsPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public abstract void validate(Object value) throws ValidationException, LoggerException;

    private void verifyType(Object value) throws Exception{

        Class<?> objectClassType= value.getClass();

        if(!objectClassType.equals(this.type)){
            throw new ClassCastException("Error on converting types: "
                    +objectClassType.getName()
                    +" into "
                    +this.type.getName());
        }

    }

    public void check(Object value) throws ValidationException, LoggerException {

        try {
            verifyType(value);
            validate(value);
        }catch(Exception e){
            logger.log(new ValidationException(
                    this.getFieldName()+": "+this.getErrorMessage(), e
            ));
        }

    }


}
