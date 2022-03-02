package cc.fivelong.thread.t013_blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class T005_LinkedBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        // 元素加入队列
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.put("a" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 不同的线程从队列中取值
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (; ; ) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "-take->" + queue.take());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
