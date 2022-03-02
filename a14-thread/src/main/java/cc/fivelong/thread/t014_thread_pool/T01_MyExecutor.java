package cc.fivelong.thread.t014_thread_pool;

import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor {

    public static void main(String[] args) {
        new T01_MyExecutor().execute(() -> {
            System.out.println("hello executor!");
        });
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
