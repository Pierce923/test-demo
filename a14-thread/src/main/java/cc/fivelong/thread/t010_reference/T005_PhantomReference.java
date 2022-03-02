package cc.fivelong.thread.t010_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * 虚引用
 * 如果对象只有虚引用在任何时候都可能被回收。
 * 虚引用主要用来跟踪垃圾回收的活动，垃圾回收后会将引用对象信息写入 引用队列中
 */
@SuppressWarnings("all")
public class T005_PhantomReference {

    /**
     * -Xms20M -Xmx20M
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        // 调用M，回收时可以打印finalize
        ReferenceQueue<M> queue = new ReferenceQueue<M>();
        // 新建虚引用
        PhantomReference<M> phantomReference = new PhantomReference<M>(new M(), queue);
        // 启动线程，向虚引用增加内存byte[]
        new Thread(() -> {
            while (true) {
                list.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + phantomReference.get());
            }
        }).start();

        // 启动线程监控queue队列，如果队列中有值，表示虚引用被回收了
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->queue.poll start!");
            while (true) {
                Reference<? extends M> poll = queue.poll();
                if (null != poll) {
                    System.out.println("gc->" + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
