package cc.fivelong.thread.t008_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可重入锁
 */
@SuppressWarnings("all")
public class T001_ReentrantLock {


    Lock lock = new ReentrantLock();

    void m1() {
        System.out.println(Thread.currentThread().getName() + "--->m1 start!");
        try {
            lock.lock();
            Thread.sleep(1000);
            m2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + "--->m1 end!");
    }

    void m2() {
        System.out.println(Thread.currentThread().getName() + "---> m2 start!");
        try {
            lock.lock();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + "---> m2 end!");
    }


    public static void main(String[] args) {
        T001_ReentrantLock t = new T001_ReentrantLock();
        t.m1();
    }
}
