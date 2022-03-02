package cc.fivelong.thread.t014_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors可提供线程池
 * newCachedThreadPool创建一个可缓存线程池
 * newFixedThreadPool 创建一个定长线程池，可限制线程数量
 * newScheduledThreadPool 创建一个定长线程池，可指定执行时间
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务
 */
@SuppressWarnings("all")
public class T03_Executors {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("hell Executors");
        };
        // 缓存线程池，可灵活回收
//        newCachedThreadPool(runnable);

        // 创建线程，可以控制最大线程数量，超出的线程会在队列中等待
//        newFixedThreadPool(runnable);

        // 定时执行线程池
//        newScheduledThreadPool(runnable);

        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务
        newSingleThreadExecutor(runnable);
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务
     */
    private static void newSingleThreadExecutor(Runnable runnable) {
        ExecutorService e4 = Executors.newSingleThreadExecutor();
        e4.execute(runnable);
        e4.shutdown();
    }


    /**
     * 创建线程，可以控制最大线程数量，超出的线程会在队列中等待
     */
    private static void newFixedThreadPool(Runnable runnable) {
        ExecutorService e2 = Executors.newFixedThreadPool(2);
        e2.execute(runnable);
        e2.shutdown();
    }

    /**
     * 定时执行线程池
     */
    private static void newScheduledThreadPool(Runnable runnable) {
        ScheduledExecutorService e3 = Executors.newScheduledThreadPool(1);
        e3.schedule(runnable, 3, TimeUnit.SECONDS);
        e3.shutdown();
    }

    /**
     * 创建一个可缓存线程池，可灵活回收
     */
    private static void newCachedThreadPool(Runnable runnable) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(runnable);
        // 必须关闭线程
        executor.shutdown();
    }

}
