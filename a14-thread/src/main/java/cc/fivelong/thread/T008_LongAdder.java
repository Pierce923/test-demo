package cc.fivelong.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class T008_LongAdder {

    static LongAdder longAdder = new LongAdder();

    void m() {
        for (int i = 0; i < 10000; i++) {
            longAdder.increment();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        T008_LongAdder t = new T008_LongAdder();
        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Thread(t::m, "thread->" + i));
        }
        list.forEach((o) -> {
            o.start();
        });
        list.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println(longAdder.longValue() + "--时间-->" + (endTime - startTime));
    }

}
