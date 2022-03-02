package cc.fivelong.t06_gc;

import java.util.ArrayList;
import java.util.List;

/**
 * GC调优
 */
public class T001_HelloGC {

    // -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC -XX:+PrintGCDetails  设置堆大小-Xmn 新生代的大小
    //  -XX:+UseConcMarkSweepGC -XX:+PrintCommandLineFlags -XX:+PrintGC -XX:+PrintGCDetails CMS GC
    public static void main(String[] args) {
        System.out.println("Hello GC");

        List<Object> list = new ArrayList<Object>();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }

    }

}
