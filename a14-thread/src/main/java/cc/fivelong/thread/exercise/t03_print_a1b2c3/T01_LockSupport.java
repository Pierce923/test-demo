package cc.fivelong.thread.exercise.t03_print_a1b2c3;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * 要求用线程顺序打印A1B2C3....Z26
 */
public class T01_LockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] aa = "ABCD".toCharArray();
        char[] bb = "1234".toCharArray();
        // 先执行t1 打印a-z
        t1 = new Thread(() -> {

            for (char str : aa) {
                System.out.println(str);
                LockSupport.unpark(t2); // 唤醒t2
                LockSupport.park(); // 阻塞t1
            }
        });

        // 执行t2，打印1-26
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char str : bb) {
                    System.out.println(str);
                    LockSupport.unpark(t1); // 唤醒t1
                    LockSupport.park(); // 阻塞t2
                }
            }
        });


        t1.start();
        t2.start();

    }

}
