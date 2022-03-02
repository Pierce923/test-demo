package cc.fivelong.thread.t012_vector_to_queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressWarnings("all")
public class T004_Ticket4 {

    static Queue<String> tickets = new ConcurrentLinkedQueue<String>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    String poll = tickets.poll();
                    if (null != poll) {
                        System.out.println(Thread.currentThread().getName() + "--售出了-->" + poll);
                    } else {
                        break;
                    }
                }
            }).start();
        }

    }

}
