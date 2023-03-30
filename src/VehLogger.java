import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Klasa implementacija loggera
 */
public class VehLogger {
    VehLogger(){
        handler();
    }

    /**
     * Implementacija handlera i formatiranja zapisa u log datoteku.
     */
    public void handler(){
        try{
        FileHandler fileHandler = new FileHandler("logs.log");
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.warning("Failed to initialize file logger: " + e.getMessage());
        }
    }

    public void logInfo(String message) {
        logger.info(message);
    }
    public void logError(Throwable throwable) {
        logger.severe(throwable.getMessage());
    }
    public void logUnexpected(Throwable throwable){logger.severe(throwable.toString());}
    private static final Logger logger = Logger.getLogger("VehLogger");
}
