package com.facefeel.service.imp;

import com.facefeel.service.NotifyService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author FaceFeel
 * @Created 2017-12-03 19:59
 */

public class NotifyServiceImpl implements NotifyService {

    @Override
    public Boolean notifyService() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssS");
        System.out.println("notify is working...time is:" + format.format(new Date()));
        int j = 0;

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("this is :" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (j == 99) {
            System.out.println("notify is ending...time is :" + format.format(new Date()));
            return true;
        }
        return false;
    }

    @Override
    public Boolean sameTime() {

        final int[] i = {0};
        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyService();
                i[0] = 1;
            }
        }.start();

        if (i[0] == 1) {
            return true;
        } else {
            return false;
        }
    }
}
