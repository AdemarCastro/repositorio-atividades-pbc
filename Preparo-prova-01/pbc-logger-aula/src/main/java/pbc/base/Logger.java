package pbc.base;

import pbc.exception.LoggerException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements ILog{

    private String source;

    private String fileName;

    private static final String fileExtension = ".log";

    private static final String fileNameMomentPattern = "yyyy-MM-dd-HH-mm-ss";

    private static final String logItemMomentPattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void setSource(String source) throws LoggerException {
        this.source = source;
        if (this.source == null){
            throw new LoggerException("Source não pode ser nulo!");
        }
        setFileName();
    }

    private void setFileName(){
        // "nomeDoArquivo-2023-08-21-09-32-53.log"

        String moment = buildMoment(fileNameMomentPattern);
        this.fileName = this.source + "-" + moment + fileExtension;
    }

    private String buildMoment(String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.now().format(formatter);
    }

    @Override
    public void log(String message) throws LoggerException {
        // try-with-resources
        try (
            FileWriter fileWriter = new FileWriter(fileName); PrintWriter printWriter = new PrintWriter(fileWriter);
        ){
            printWriter.println(buildMoment(logItemMomentPattern));
            printWriter.println(message);
        }catch (IOException e){
            throw new LoggerException("Problema ao criar o arquivo", e);
        }
    }

    @Override
    public void log(Throwable throwable) throws LoggerException {
        try (
                FileWriter fileWriter = new FileWriter(fileName, true); PrintWriter printWriter = new PrintWriter(fileWriter);
        ){
            printWriter.println(buildMoment(logItemMomentPattern));
            throwable.printStackTrace(printWriter);
        }catch (IOException e){
            throw new LoggerException("Problema ao criar o arquivo", e);
        }
    }
}
