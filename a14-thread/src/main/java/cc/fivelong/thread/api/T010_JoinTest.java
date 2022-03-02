package cc.fivelong.thread.api;

/**
 * join()
 * 调用该方法的线程强制执行，其它线程处于阻塞的状态
 * 该方法执行完毕后，其它线程再执行
 */
public class T010_JoinTest {

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
        Thread t1 = new Thread(myRun);
        t1.start();
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            if (i==2) {
                try {
                    // 强制阻断当前执行线程，执行t1线程
                    t1.join();
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
