package com.servlet.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author FaceFeel
 * @Created 2017-12-10 13:49
 */

public class TestController {

    public static void main(String [] args){

        Timer timer = new Timer();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,Calendar.DECEMBER,10,14,16,0);

        timer.schedule(new MyTask(),calendar.getTime());
    }
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current date:" + simpleDateFormat.format(new Date()));
    }
}
