package cc.fivelong.thread.exercise.t05_ticket;

/**
 * 出票
 * 使用synchronized同步代码块()
 */
public class T011_TicketSyncThread implements Runnable {

    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 同步代码块
            synchronized (this){
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "--->" + (ticket--));
                }
            }
        }
    }

    public static void main(String[] args) {
        T011_TicketSyncThread thread = new T011_TicketSyncThread();
        Thread t1 = new Thread(thread, "A");
        Thread t2 = new Thread(thread, "B");
        Thread t3 = new Thread(thread, "C");
        Thread t4 = new Thread(thread, "D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
