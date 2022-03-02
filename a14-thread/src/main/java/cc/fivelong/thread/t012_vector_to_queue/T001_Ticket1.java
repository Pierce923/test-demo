package cc.fivelong.thread.t012_vector_to_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用List集合买票
 */
@SuppressWarnings("all")
public class T001_Ticket1 {

    static List<String> list = new ArrayList<String>();

    static {
        for (int i = 0; i < 1000; i++) {
            list.add("票号：" + i);
        }
    }

    /**
     * 由于数据不是同步的，导致会出现抢占资源的问题，有的线程会多买一些。
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (list.size() > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + list.get(0));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.remove(0);
                }
            }).start();
        }

    }

}
