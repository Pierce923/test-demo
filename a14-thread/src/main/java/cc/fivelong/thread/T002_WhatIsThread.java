package cc.fivelong.thread;

import java.util.concurrent.TimeUnit;

/**
 * 什么是线程？
 * 有多个执行路径。
 * @author youjinbo
 */
public class T002_WhatIsThread {

    private static class T1 extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10 ; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }

    }

    public static void main(String[] args){
        // thread start运行：不同的执行路径   run：只有一个执行路径
        new T1().start();
       // new T1().run();
        for (int i = 0; i < 10 ; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }


}
