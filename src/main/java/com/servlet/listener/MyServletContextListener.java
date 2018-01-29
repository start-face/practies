package com.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author FaceFeel
 * @Created 2017-12-10 14:55
 */
//@WebListener
public class MyServletContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.err.println("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.err.println("contextDestroyed");
    }
}
