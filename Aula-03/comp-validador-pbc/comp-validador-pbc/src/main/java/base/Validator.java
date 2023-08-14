package base;

import exceptions.ValidationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class Validator {

    private String fieldName;

    private String errorMessage;

    private Class<?> type;

    private static Logger globalLogger;
    private static FileHandler fileHandler;



    public Validator(String fieldName, String errorMessage, Class<?> type) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.type = type;

        // Criar a pasta "logs" na raiz do projeto, caso não exista
        createLogsDirectory();

        configureLogger();
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

    private synchronized void configureLogger() {
        if (globalLogger == null) {
            globalLogger = Logger.getLogger("GlobalLogger");

            try {
                if (fileHandler == null) {
                    // Obtém o diretório onde o JAR está localizado
                    String jarDirectory = Paths.get("").toAbsolutePath().toString();
                    String logFilePath = Paths.get(jarDirectory, "logs", "validation.log").toString();

                    fileHandler = new FileHandler("logs/validation.log", true);
                    fileHandler.setFormatter(new SimpleFormatter());
                }
                globalLogger.addHandler(fileHandler);
            } catch (IOException e) {
                globalLogger.log(Level.SEVERE, "Error setting up logger", e);
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
        }catch(Exception e){
            globalLogger.warning("Validation error: " + getFieldName() + ": " + e.getMessage());
            throw new ValidationException(this.getFieldName() + ": " + this.getErrorMessage(), e);

        }

    }


}
