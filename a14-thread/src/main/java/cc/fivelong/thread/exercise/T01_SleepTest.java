package cc.fivelong.thread.exercise;

/**
 * 创建多个线程，线程1输出1-10，线程2输出10-1，交替输出
 */
public class T01_SleepTest {

    static class MyRunable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
                try {
                    Thread.sleep(1020);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyRunable myRun = new MyRunable();
        Thread t = new Thread(myRun);
        t.start();
        for (int i = 10; i > 0 ; i--) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
