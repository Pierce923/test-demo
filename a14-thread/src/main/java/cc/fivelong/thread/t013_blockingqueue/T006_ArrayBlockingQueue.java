package cc.fivelong.thread.t013_blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T006_ArrayBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        // 向队列中添加元素
        for (int i = 0; i < 100; i++) {
//            queue.add("a" + i);
//            queue.offer("a"+i); // 如果队列没满，立即返回true； 如果队列满了，立即返回false-->不阻塞
            try {
                // 在队尾插入一个元素,，如果队列已满，则进入等待
                queue.offer("a"+i, 1000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*try {
                queue.put("a" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        // 从队列中取值
        for (int i = 0; i < 500; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "- take->" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
