package com.tw.common;

import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class Log4jInitialiser implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        File file = new File("/WEB-INF/classes/log4j.xml");
        DOMConfigurator.configure("/WEB-INF/classes/log4j.xml");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
