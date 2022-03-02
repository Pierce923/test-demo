package cc.fivelong.thread.exercise.t05_ticket;

/**
 * 类数据共享使用static
 *
 */
@SuppressWarnings("all")
public class T010_TicketThread extends Thread {

    //private int ticketCount = 5; //私有变量， 创建实例时，为实例的私有变量
    private static int ticketCount = 5; // static称为类的全局变量，创建实例时，共享数据

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            if (ticketCount > 0) {
                System.out.println(Thread.currentThread().getName() + "--第" + (ticketCount--) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        T010_TicketThread t1 = new T010_TicketThread();
        T010_TicketThread t2 = new T010_TicketThread();
        T010_TicketThread t3 = new T010_TicketThread();
        T010_TicketThread t4 = new T010_TicketThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
