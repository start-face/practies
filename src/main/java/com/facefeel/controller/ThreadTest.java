package com.facefeel.controller;

/**
 * @author FaceFeel
 * @Created 2018-02-01 10:45
 */

public class ThreadTest implements Runnable{

    private B b;

    public ThreadTest(B b){
        this.b = b;
    }

    public static void main(String[] args) {

//        B b = new B();
        for (int i=0;i<3;i++){
//            new Thread(new ThreadTest(b)).start();
            new Thread(new ThreadTest(new B())).start();
        }
    }

    @Override
    public void run() {
        b.set1();
        b.set2();
        b.print();
    }
}

class B {
    private int b = 0;

    public void set1() {
        b = 0;
    }

    public void set2() {
        b = -1;
    }

    public void print() {
        if (b != 0 && b != -1) {
            System.err.println("ERROR");
        }
    }
}
