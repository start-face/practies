package com.facefeel.controller;

import com.facefeel.service.NotifyService;
import com.facefeel.service.NotifyServiceClass;
import com.facefeel.service.imp.NotifyHandleImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author FaceFeel
 * @Created 2017-12-03 18:27
 */

public class NotifyController2 {

    static final SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssS");

//    public void startWork(int i, AsyncHandle asyncHandle) {
    public void startWork(int i, NotifyServiceClass asyncHandle) {

        System.out.println("work_" + i + " is starting...time is:" + formate.format(new Date()));
        asyncHandle.callback();
    }

    public static void main(String[] args) {

//        AsyncHandle asyncHandle = new AsyncHandle() {
//            @Override
//            public void handle() {
//                System.out.println("handle is starting...time is :" + formate.format(new Date()));
//                for (int i = 0; i < 5; i++) {
//                    try {
//                        Thread.sleep(1000);
//                        System.out.println("this is:" + i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("handle is ending...time is :" + formate.format(new Date()));
//            }
//        };

        NotifyServiceClass notifyService = new NotifyHandleImpl();

        NotifyController2 notify = new NotifyController2();
//        notify.startWork(1, asyncHandle);
        notify.startWork(1, notifyService);
        System.out.println("main Thread is ending...time is :" + formate.format(new Date()));
    }
}

abstract class AsyncHandle {

    public void callback() {

        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssS");

        System.out.println("callback is starting...time is:" + formate.format(new Date()));

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handle();
            }
        }.start();
        System.out.println("callback is ending...");
    }

    /**
     * 任务处理的方法
     */
    abstract public void handle();
}
