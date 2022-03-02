package cc.fivelong.thread.t008_lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrier一般用于一组线程互相等待至某个状态，然后一组线程同时执行。
 * 复杂操作：
 * 数据库
 * 网络
 * 文件
 * <p>
 * 并发执行-应用：
 * 线程-获取数据库信息
 * 线程获取网络信息
 * 进行比较或者其它操作
 */
public class T003_CyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, () -> System.out.println("go"));

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
