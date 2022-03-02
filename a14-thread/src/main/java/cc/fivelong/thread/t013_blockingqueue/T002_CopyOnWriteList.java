package cc.fivelong.thread.t013_blockingqueue;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteList
 * 多个线程同时修改一个容器
 */
@SuppressWarnings("all")
public class T002_CopyOnWriteList {

    public static void main(String[] args) {
        // 创建CopyOnWriteArrayList
        // 向list新增元素
        List<String> list = new CopyOnWriteArrayList<>();
        Random random = new Random();
        // 通过100个线程向CopyOnWriteArrayList新增元素
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        list.add(Thread.currentThread().getName() + "->" + random.nextInt(1000));
                    }
                }
            };
            // 线程加入线程池
            threads[i] = new Thread(runnable, "thread-" + i);
        }
        // 启动线程
        startThread(threads);
        // 打印
        print(list);
    }

    private static void startThread(Thread[] threads) {
        // 启动线程池中的线程
        Arrays.asList(threads).forEach(t -> t.start());
        // 等待其它线程先执行
        Arrays.asList(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void print(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(list.size());
    }


}
