package cc.fivelong.thread.t008_lock;

public class T007_SynchronizedDemo {

    public void method() {
        synchronized (this) {
            System.out.println("method");
        }
    }

    public static void main(String[] args) {

    }

}
