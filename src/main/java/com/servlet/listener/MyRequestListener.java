package com.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Servlet的监听器，用于监听ServletRequest对象的产生和销毁
 * @author FaceFeel
 * @Created 2017-12-10 14:17
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.err.println("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        System.err.println("requestInitialized");
    }
}
