package cc.fivelong.thread.t014_thread_pool;

import java.util.concurrent.*;

/**
 * Callable与Runnable相似
 * 1. Callable可以在任务结束时候提供一个返回值，Runnable无法提供这个功能。
 * 2. Callable的call可以抛出异常，而Runable的run方法不能抛出异常。
 * 3. Callable必须联合线程池使用。<T> Future<T> submit(Callable<T> task)
 */
public class T04_Callable {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello Callable";
            }
        };

        ExecutorService e = Executors.newCachedThreadPool();
        Future<String> future = e.submit(callable);
        System.out.println(future.get()); // future.get()阻塞状态，等待返回值
        e.shutdown();
    }

}
