package cc.fivelong.thread.t009_aqs;


public class T0092_TestLock{

    private static Sync sync = new Sync();

    public static void main(String[] args) {
        // 获取资源
        sync.acquire(1);
    }

}
