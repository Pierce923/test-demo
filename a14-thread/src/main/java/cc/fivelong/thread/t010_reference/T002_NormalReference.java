package cc.fivelong.thread.t010_reference;

import java.io.IOException;

/**
 * 强引用
 * m=null 打断引用，不指向任何引用
 */
public class T002_NormalReference {

    public static void main(String[] args) throws IOException {
        System.out.println("NormalReference start!");
        M m = new M();
        // 打断引用，不指向任何引用
        m = null;
        System.gc();

        System.in.read();
    }

}
