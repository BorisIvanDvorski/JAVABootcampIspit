import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class VehLogger {
    private final static Logger logger;


    static {
        logger = Logger.getLogger("VehLogger");
        try {
            FileHandler fileHandler = new FileHandler("logs.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.warning("Failed to initialize file logger: " + e.getMessage());
        }
    }
    public static void logInfo(String message) {
        logger.info("Info:"+message);
    }
    public static void logError(Throwable throwable) {
        logger.severe("Error: "+throwable.getMessage());
    }
}
