package com.facefeel.service.imp;

import com.facefeel.service.NotifyServiceClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author FaceFeel
 * @Created 2017-12-03 21:04
 */

public class NotifyHandleImpl extends NotifyServiceClass{

    @Override
    public Boolean handle() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssS");
        System.out.println("notify is working...time is:" + format.format(new Date()));
        int j = 0;

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("this is :" + i);
                j=i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (j == 9) {
            System.out.println("notify is ending...time is :" + format.format(new Date()));
            return true;
        }
        return false;
    }
}
