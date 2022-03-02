package cc.fivelong.thread.t008_lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport线程阻塞工具类
 * 有的方法都是静态方法，可以让线程在任意位置阻塞，当然阻塞之后肯定得有唤醒的方法。
 */
public class T004_LockSupport {

    void m1() {
        System.out.println(Thread.currentThread().getName() + "-->m1");
        LockSupport.park();
        if (Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + "-->interrupted");
        }
        System.out.println(Thread.currentThread().getName() + "-->继续执行");
    }

    /**
     * t1中断后，通过LockSupport.unpark继续执行
     * t2中断后，没有再次启动
     */
    public static void main(String[] args) throws InterruptedException {
        T004_LockSupport t = new T004_LockSupport();

        Thread t1 = new Thread(t::m1, "t1");
        Thread t2 = new Thread(t::m1, "t2");
        t1.start();
        Thread.sleep(2000);
        t2.start();
        // 给线程设置中断状态
        //t1.interrupt();
        LockSupport.unpark(t1);

        t2.interrupt();

    }

}
