package cc.fivelong.thread.t010_reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 当内存空间不足时，会清除软引用对象
 */
public class T003_SoftReference {

    public static void main(String[] args) {
        // -Xms20M -Xmx20M
        SoftReference softReference = new SoftReference(new byte[1024*1024*10]);
        System.out.println("gc之前---"+softReference.get());
        System.gc();
        System.out.println("gc之后---"+softReference.get());

        System.out.println("--------------------------------");
        // 当内存空间不足时，清理软引用空间
        byte[] b = new byte[1024*1024*10];
        System.out.println(softReference.get());
    }

}
