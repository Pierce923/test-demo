package cc.fivelong.thread.t009_aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS源码阅读
 * lock()方法
 */
@SuppressWarnings("all")
public class T0091_ReentrantLock {

    private static Sync sync = new Sync();

    public static void main(String[] args) {
        // 读取lock()源码
//        m1();
        // 读取acquire()源码
        m2();
    }

    static void m2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "m2");
                ReentrantLock reentrantLock = new ReentrantLock();
                reentrantLock.lock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "sync");
        sync.acquire(1);


    }

    /**
     * 读取lock()源码
     */
    static void m1(){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
//        reentrantLock.tryLock();

        ReentrantLock reentrantLock2 = new ReentrantLock();
        reentrantLock2.lock();

        reentrantLock.unlock();
        reentrantLock2.unlock();
    }


}
