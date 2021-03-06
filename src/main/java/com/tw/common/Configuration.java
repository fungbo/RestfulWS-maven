package com.tw.common;

import org.apache.log4j.Logger;

import java.util.Properties;

public class Configuration {
    private static final Logger LOGGER = Logger.getLogger(Configuration.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.ACCOUNT_PROPERTIES_FILE));
        } catch (Exception e) {
            LOGGER.error("Load account.properties error");
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
