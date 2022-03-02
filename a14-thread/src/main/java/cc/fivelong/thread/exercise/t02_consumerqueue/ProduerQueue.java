package cc.fivelong.thread.exercise.t02_consumerqueue;

import java.util.concurrent.BlockingQueue;

public class ProduerQueue implements Runnable {

    private BlockingQueue<Goods> blockingQueue;

    public ProduerQueue(BlockingQueue<Goods> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Goods goods = null;
            if (i % 2 == 0) {
                goods = new Goods("矿泉水" + i, "怡宝" + i);
            } else {
                goods = new Goods("辣条" + i, "麻辣王子" + i);
            }
            try {
                blockingQueue.put(goods);
                System.out.println("生产者生产了-->" + goods.getBrand() + "--" + goods.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
