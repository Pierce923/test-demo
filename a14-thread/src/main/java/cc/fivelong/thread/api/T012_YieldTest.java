package cc.fivelong.thread.api;

public class T012_YieldTest {

    static class MyRunable implements Runnable {


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
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + "--礼让一次-->" + i);
            } else {
                System.out.println(Thread.currentThread().getName() + "--->" + i);
            }
        }


    }


}
