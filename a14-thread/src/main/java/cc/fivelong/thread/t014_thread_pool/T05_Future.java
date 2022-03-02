package cc.fivelong.thread.t014_thread_pool;

import java.util.concurrent.*;

/**
 * Future联合Callable，在Callable线程执行完成或失败后，做出相应操作。
 */
public class T05_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("购物");
                System.out.println("刷剧");
                System.out.println("游戏");
                return "Callable done.";
            }
        };

        ExecutorService e = Executors.newCachedThreadPool();
        Future<String> future = e.submit(callable);

        System.out.println(future.get());
        // future有返回值，执行xxx
        if (future.isDone()) {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("aa");
        }

        e.shutdown();
    }

}
