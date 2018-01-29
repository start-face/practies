package com.tuhao.pool;

import java.util.LinkedList;

public class WorkQueue {

    private final int nThreads;
    private final PoolWork [] threads;
    private final LinkedList<Runnable> queue;

    public WorkQueue(int nThreads){

        this.nThreads=nThreads;
        this.threads = new PoolWork[nThreads];
        this.queue = new LinkedList<>();

        for(int i=0;i<nThreads;i++){

            threads[i] = new PoolWork();
            threads [i].start();
        }
    }

    public void execute(Runnable runnable){

        synchronized (queue){

            queue.addLast(runnable);
            queue.notify();
        }
    }

    private class PoolWork extends Thread{

        public void run(){

            Runnable runnable;

            while(true){

                synchronized (queue){

                    while(queue.isEmpty()){

                        try {
                            queue.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    runnable = queue.removeFirst();
                }

                try {
                    runnable.run();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
