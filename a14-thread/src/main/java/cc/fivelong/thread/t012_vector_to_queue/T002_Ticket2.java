package cc.fivelong.thread.t012_vector_to_queue;

import java.util.Vector;

/**
 * 使用verctor来同步数据
 */
public class T002_Ticket2 {

    static Vector<String> tickets = new Vector<String>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号：" + i);
        }
    }

    /**
     * vector.size可以读取0以上的值
     * 但是vector.remove()删除时，数据可能已经被删除了
     * while循环里面不是原子性的
     * <p>
     * synchronized int size()
     * boolean remove(Object o)  remove不是synchronized
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    System.out.println(Thread.currentThread().getName() + "--售出了-->" + tickets.get(0));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets.remove(0);
                }
            }).start();
        }

    }

}
