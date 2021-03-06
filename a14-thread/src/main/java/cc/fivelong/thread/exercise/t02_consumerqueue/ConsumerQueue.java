package cc.fivelong.thread.exercise.t02_consumerqueue;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable {

    private BlockingQueue<Goods> blockingQueue;

    public ConsumerQueue(BlockingQueue<Goods> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Goods goods = blockingQueue.take();
                System.out.println("消费者消费了-->" + goods.getBrand() + "--" + goods.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
