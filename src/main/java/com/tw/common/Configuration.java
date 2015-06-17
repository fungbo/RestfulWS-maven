package com.tw.common;

import org.apache.log4j.Logger;

import java.util.Properties;

public class Configuration {
    private static final Logger LOGGER = Logger.getLogger(Configuration.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("account.properties"));
        } catch (Exception e) {
            LOGGER.error("Load account.properties error");
        }
    }

    public static String getProperty(String key) {
        try {
            return properties.getProperty(key);
        } catch (Exception e) {
            return null;
        }
    }
}
