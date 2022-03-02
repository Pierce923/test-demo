package cc.fivelong.thread;

/**
 * synchronized可重入性：
 * 一个线程请求其它线程持有的对象锁时，会阻塞。
 * 但是一个线程持有某个对象的锁，再次申请时，依然会得到该对象的锁。
 */
@SuppressWarnings("all")
public class T005_ReentrantSync {

    synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "-->m1 start!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println(Thread.currentThread().getName() + "-->m1 end!!");
    }

    synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "-->m2 start!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->m2 end!!");
    }

    public static void main(String[] args) {
        new T005_ReentrantSync().m1();
    }

}
