package com.facefeel.service;

/**
 * @author FaceFeel
 * @Created 2017-12-03 21:01
 */

abstract public class NotifyServiceClass {

    public Integer callback() {

        final Boolean[] flag = {false};
        final int[] i = {0};
        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag[0] = handle();
                if (flag[0]){
                    i[0] = 1;
                }
                if (!flag[0]){
                    i[0] = 5;
                }
            }
        }.start();
        if (i[0] == 1){
            return 2;
        }
        if (i[0] == 5){
            return 3;
        }

        int k = 0;
        for (int j = 0; j < 5; j++) {
            System.out.println("j=" + j);
            if (j==4){
                k=1;
            }
        }
        return k;
    }

    /**
     * deal
     * @return Boolean
     */
    abstract public Boolean handle();
}
