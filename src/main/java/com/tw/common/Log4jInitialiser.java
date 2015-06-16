package com.tw.common;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;

/**
 * This class is actually not necessary, just an example which shows how to load log4j config file
 * This class can be removed, then all you need to do is to put log4j file into the src/resource folder
 */
public class Log4jInitialiser implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            URL log4jUrl = Thread.currentThread().getContextClassLoader().getResource("log.xml");
            DOMConfigurator.configure(log4jUrl);
        } catch (Exception e1) {
            try {
                URL log4jProperties = Thread.currentThread().getContextClassLoader().getResource("log.properties");
                PropertyConfigurator.configure(log4jProperties);
            } catch (Exception e2) {
                System.out.println("Load log4j config file error");
            }
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
