package com.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author FaceFeel
 * @Created 2017-12-10 14:50
 */

@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionCreated");
        HttpSession session = httpSessionEvent.getSession();
        if (session.isNew()){
            System.out.println(session.getId());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        if (!session.isNew()){
            System.out.println(session.getId());
            System.out.println("sessionDestroyed");
        }
    }
}
