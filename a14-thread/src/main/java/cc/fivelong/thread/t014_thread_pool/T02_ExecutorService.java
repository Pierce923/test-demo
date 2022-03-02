package cc.fivelong.thread.t014_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T02_ExecutorService {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> {
            System.out.println("ExecutorService");
        });
        // 销毁
        executor.shutdown();
    }

}
