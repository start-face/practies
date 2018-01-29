package com.facefeel.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author FaceFeel
 * @Created 2017-12-03 11:50
 */

public class NotifyController {

    /**
     * 控制本地资源释放
     */
    private CountDownLatch countDownLatch;
    /**
     * 任务处理完成标志
     */
    private volatile boolean handleFinnished;
    /**
     * 消息写入本地完成
     */
    private volatile boolean sendFinished;
    /**
     * 阻塞队列
     */
    private BlockingQueue<String> queue;
    /**
     * 写字符流
     */
    private BufferedWriter bw;

    public NotifyController(CountDownLatch countDownLatch){

        this.countDownLatch = countDownLatch;
        /**
         * 使用链表实现
         */
        this.queue = new LinkedBlockingQueue<>();
        try {

            File file = new File("D:/hello.text");
            this.bw = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle(){

        //模拟执行的性能瓶颈，每3s执行一条消息
        new Thread(() -> {
            while(!handleFinnished){
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String peek = queue.peek();
                if (peek != null){
                    queue.poll();
                    try {
                        bw.write(peek);
                        bw.newLine();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                //如果多列为空，并且消息已经发送完成
                if (sendFinished && queue.isEmpty()){
                    //计算器由1变成0
                    countDownLatch.countDown();
                    //结束处理
                    handleFinnished = true;
                    break;
                }
            }
        }).start();
    }

    /**
     * 消息发送完成标识
     */
    public void senFinished(){
        this.sendFinished = true;
    }

    /**
     * 释放锁使用的资源
     */
    public void relaese(){
        System.err.println("release");
        if (bw != null){
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (queue != null){
            queue.clear();
            queue = null;
        }
    }

    /**
     * 往队列发送消息
     */
    public void sendMesg(String text){

        if (text != null && !text.isEmpty()){
            queue.add(text);
        }
    }


    /**
     * 主函数执行
     */
    public static void main(String [] args){

        CountDownLatch countDownLatch = new CountDownLatch(1);
        NotifyController notifyController = new NotifyController(countDownLatch);
        notifyController.handle();

        Scanner scanner = new Scanner(System.in);
        while (true){

            String next = scanner.next();
            //如果用户选择了退出
            if ("exit".equals(next)){
                //表示消息已经发送完成
                notifyController.senFinished();
                break;
            }
            notifyController.sendMesg(next);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyController.relaese();
        scanner.close();
    }
}
