package cc.fivelong.thread.t012_vector_to_queue;

import java.util.Vector;

@SuppressWarnings("all")
public class T003_Ticket3 {

    static Vector<String> tickets = new Vector<String>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号：" + i);
        }
    }

    /**
     *
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() > 0) {
                            System.out.println(Thread.currentThread().getName() + "--售出了-->" + tickets.get(0));
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            tickets.remove(0);
                        } else {
                            break;
                        }
                    }
                }
            }).start();
        }

    }

}
