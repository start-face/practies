package com.facefeel.controller;

import com.facefeel.service.NotifyService;
import com.facefeel.service.NotifyServiceClass;
import com.facefeel.service.imp.NotifyHandleImpl;
import com.facefeel.service.imp.NotifyServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author FaceFeel
 * @Created 2017-12-03 19:56
 */

@WebServlet("/notify")
public class NotifyServlet extends HttpServlet {

    private NotifyService notifyService;
    private Boolean isSuccess;

    @Override
    public void init() {
        if (notifyService == null) {
            notifyService = new NotifyServiceImpl();
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssS");
        System.out.println("NotifyServlet is working...time is :" + format.format(new Date()));
        NotifyServiceClass notify = new NotifyHandleImpl();
        callback(notify);
        PrintWriter out = response.getWriter();
        if (isSuccess){
            out.print("this is redirect....");
        }else {
            out.print("this is page...");
        }
        System.out.println("NotifyServlet is ending...time is :" + format.format(new Date()));
    }


    private void callback(NotifyServiceClass notifyServiceClass) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssS");
        System.out.println("callback is working...time is:" + format.format(new Date()));
        Integer callback = notifyServiceClass.callback();
        System.out.println("result is :" + callback);
        System.out.println("callback is ending...time is :" + format.format(new Date()));

        if (callback ==1){
            isSuccess = false;
        }else {
            isSuccess = true;
        }
    }
}
