package cc.fivelong.thread.api;

/**
 * sleep()休眠方法，线程处于阻塞状态
 */
public class T011_SleepTest {

    static class MyRunable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyRunable myRun = new MyRunable();
        Thread t = new Thread(myRun);
        t.start();
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + "-->"+i);
            if (i == 1) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
