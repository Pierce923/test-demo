package cc.fivelong.thread.t014_thread_pool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义拒绝策略
 * 当线程被占用，队列满了以后，增加一个自定义拒绝策略
 */
@SuppressWarnings("all")
public class T08_ThreadPoolExecutor_MyPolicy {


    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            new MyRejectedExecutionHandler()); // 自定义拒绝策略

    /**
     * 创建Runnable
     */
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " My");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 自定义解决策略
     */
    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(Thread.currentThread().getName() + " MyRejectedExecutionHandler");
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        for (int i = 0; i < 11; i++) {
            threadPool.execute(runnable);
        }

        threadPool.shutdown();
    }

}
