package cc.fivelong.thread.t010_reference;

import java.io.IOException;

public class T001_TestReference {

    public static void main(String[] args) throws IOException {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        threadLocal.set("m");
        // ThreadLocal中有私有空间ThreadLocalMap，当对象被回收后，删除ThreadLocalMap中对应的key
        threadLocal.remove();
    }

}
