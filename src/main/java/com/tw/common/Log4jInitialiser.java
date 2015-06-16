package com.tw.common;

import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jInitialiser implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DOMConfigurator.configure("/WEB-INF/classes/log4j.xml");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
