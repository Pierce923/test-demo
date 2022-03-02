package cc.fivelong.thread.t008_lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch等待其它线程执行完成后，再执行
 * 通过计数器来实现
 */
@SuppressWarnings("all")
public class T005_CountDownLatch {

    public static void main(String[] args) {
        System.out.println("启动主线程 start");
        CountDownLatch latch = new CountDownLatch(2);
        // 线程1
        ExecutorService e1 = Executors.newSingleThreadExecutor();
        e1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->done!");
                latch.countDown();
            }
        });
        e1.shutdown();
        // 线程2
        ExecutorService e2 = Executors.newSingleThreadExecutor();
        e2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->done ??");
                latch.countDown();
            }
        });
        e2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行主线程-end");
    }

}
