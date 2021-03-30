package com.podium.testautomation.settings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static Logger logger = LoggerFactory.getLogger(Log.class);

    public static void logInfo(String info) {
        try {
            logger.info(info);
        } catch (Exception e) {

        }
    }

    public static void logError(String error) {
        try {
            logger.error(error);
        } catch (Exception e) {

        }
    }

}
