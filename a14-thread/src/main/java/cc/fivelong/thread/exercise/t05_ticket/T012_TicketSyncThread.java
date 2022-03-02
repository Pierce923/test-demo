package cc.fivelong.thread.exercise.t05_ticket;

/**
 * 出票
 * 使用synchronized同步方法
 */
@SuppressWarnings("all")
public class T012_TicketSyncThread implements Runnable {

    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 同步方法
            this.sale();
        }
    }

    // 同步方法
    private synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "--->" + (ticket--));
        }
    }

    public static void main(String[] args) {
        T012_TicketSyncThread thread = new T012_TicketSyncThread();
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
