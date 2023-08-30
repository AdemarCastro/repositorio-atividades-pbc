package log.ui;

import java.util.logging.Level;

public interface ILogger {

    void log(Level level, String message, Throwable exception);

}
