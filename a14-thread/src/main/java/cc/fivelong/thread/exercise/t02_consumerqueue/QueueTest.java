package cc.fivelong.thread.exercise.t02_consumerqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用JUC BlockingQueue队列进行消费
 */
public class QueueTest {

    public static void main(String[] args) {
        BlockingQueue<Goods> blockingQueue = new ArrayBlockingQueue<Goods>(5);
        ProduerQueue produerQueue = new ProduerQueue(blockingQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);
        new Thread(produerQueue).start();
        new Thread(consumerQueue).start();
    }

}
