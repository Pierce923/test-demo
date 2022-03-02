package cc.fivelong.thread;

/**
 * ThreadLocal 线程私有内存
 * 线程私有
 */
public class T009_ThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<String>();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 给不同的线程随机赋值
                    local.set("" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-->" + local.get());
                    local.remove();
                }
            }).start();

        }

    }

}
