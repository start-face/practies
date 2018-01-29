package com.tuhao.multi;

public class MultiOne implements Runnable {

    @Override
    public void run() {

        System.err.println("这是实现Runnable接口的线程！");
    }
}
