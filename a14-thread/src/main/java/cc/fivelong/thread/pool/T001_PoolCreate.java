package cc.fivelong.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("all")
public class T001_PoolCreate {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executorService.execute(new PoolTask());
        }
        executorService.shutdown();
    }

}
