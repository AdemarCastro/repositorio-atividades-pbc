package log.model;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.nio.file.Paths;

public class Log {

    private static Logger globalLogger;
    private static FileHandler fileHandler;

    public static void configureLogger() {
        if (globalLogger == null) {
            globalLogger = Logger.getLogger("GlobalLogger");

            try {
                if (fileHandler == null) {
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

    public static void log(Level level, String message, Throwable exception) {
        configureLogger();
        globalLogger.log(level, message, exception);
    }

}
