package cc.fivelong.thread.pool;

public class PoolTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
