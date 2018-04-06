/*
 * Copyright (c) 2018. Murphy
 */

package cn.murphypen.Java_GUI.Unit5_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadA extends Thread {
    @Override
    public void run() {
        System.out.println("MyThreadA");
        notify();
        System.out.println("MyThreadA");
    }
}

class MyThreadB extends Thread {
    @Override
    public void run() {
        System.out.println("MyThreadB");
        try {
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyThreadB");
    }
}

public class MyWindow {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(new MyThreadA());
        es.submit(new MyThreadB());

        es.shutdown();
    }
}
