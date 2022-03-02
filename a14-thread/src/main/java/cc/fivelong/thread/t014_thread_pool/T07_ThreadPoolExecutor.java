package cc.fivelong.thread.t014_thread_pool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T07_ThreadPoolExecutor {

    // corePoolSize 线程池维护线程的最小数量
    // maximumPoolSize 线程池维护线程的最大数量
    // keepAliveTime 线程池维护线程所允许的空闲时间
    // BlockingQueue 线程池所使用的的缓冲队列
    // RejectedExecutionHandler 线程池对拒绝任务的处理策略 线程池忙，缓冲队列满了，执行解决策略
    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
//            new ThreadPoolExecutor.AbortPolicy()
//            new ThreadPoolExecutor.DiscardPolicy()
            new ThreadPoolExecutor.DiscardOldestPolicy()
//            new ThreadPoolExecutor.CallerRunsPolicy()
    );


    // 创建阻塞线程
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

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();
        for (int i = 0; i < 7; i++) {
            threadPool.execute(runnable);
        }

        threadPool.shutdown();

    }

}
