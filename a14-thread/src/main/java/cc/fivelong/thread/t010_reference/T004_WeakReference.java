package cc.fivelong.thread.t010_reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 垃圾回收器只要见到弱引用就回收。
 */
public class T004_WeakReference {

    public static void main(String[] args) {
        // 创建一个引用队列
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        // 创建一个弱引用
        WeakReference<String> weak = new WeakReference<String>(new String("hello WeakReference"), queue);
        System.out.println("WeakReference-->" + weak.get());
        // 启动gc
        System.gc();
        System.out.println("WeakReference-->" + weak.get());
    }

}
