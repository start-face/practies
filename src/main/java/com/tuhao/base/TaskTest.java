package com.tuhao.base;

import cn.dreampie.ExcutorsKit;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @autor FaceFeel
 * @create 2017-11-28 22:42
 */

public class TaskTest {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(new MyTaskTimer(),1000, TimeUnit.MILLISECONDS);
    }
}

class MyTaskTimer extends TimerTask {

    @Override
    public void run() {

        System.err.println(new Date().toLocaleString());
    }
}
