package utils;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        logger.log(Level.INFO, message);
    }

    public static void warn(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void debug(String message) {
        logger.log(Level.FINE, message);
    }
}