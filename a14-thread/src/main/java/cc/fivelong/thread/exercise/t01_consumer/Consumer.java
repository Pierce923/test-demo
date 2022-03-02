package cc.fivelong.thread.exercise.t01_consumer;

public class Consumer implements Runnable {

    private Gods gods;

    public Consumer(Gods gods) {
        this.gods = gods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            gods.get();
        }
    }

}
