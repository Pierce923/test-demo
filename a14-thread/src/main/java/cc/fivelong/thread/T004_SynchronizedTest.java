package cc.fivelong.thread;

/**
 * synchronized基本使用
 */
@SuppressWarnings("all")
public class T004_SynchronizedTest {

    static class myRun implements Runnable {

        @Override
        public void run() {
            //m();
            m2();
        }

        // synchronzied方法块 这里等同于synchronized(T.class)
        public synchronized void m2(){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  m2-->" + i);
            }
        }

        // synchronzied代码块
        public void m(){
            for (int i = 0; i < 10; i++) {
                synchronized (this){
                    System.out.println(Thread.currentThread().getName() + " 代码块-->" + i);
                }
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new myRun()).start();
        new Thread(new myRun()).start();

    }

}
