package cc.fivelong.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger.incrementAndGet底层是compareAndSwapInt
 * CAS操作
 */
public class T007_AtomicInteger {

    AtomicInteger count = new AtomicInteger(0);

    void m () {
        for (int i = 0; i < 10000; i++) {
            // 自增
            count.incrementAndGet();
        }
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        T007_AtomicInteger t = new T007_AtomicInteger();
        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Thread(t::m, "thread-" + i));
        }
        list.forEach((o) -> o.start());
        list.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println(t.count + "--时间-->" + (endTime - startTime));
    }

}
