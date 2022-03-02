package cc.fivelong.thread;

/**
 * Thread创建线程：
 * 1.继承Thread类
 * 2.重写run()方法
 * 3.调用start()方法启动线程
 * <p>
 * 使用Runable创建线程： 使用了代理设计模式
 * 1.实现Runable implements Runnable
 * 2.创建Thread对象，将Runable子类实现作为对象作为Thread的构造参数new Thread(new MyRun()).start()
 * 3.获取新的线程，线程池中获取线程，就是用Runable
 */
public class T001_CreateThread extends Thread {

    /**
     * Runable
     */
    static class MyRunable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runable--" + Thread.currentThread().getName() + "--->" + i);
            }
        }
    }

    /**
     * Thread
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread-" + Thread.currentThread().getName() + "--->" + i);
        }
    }

    public static void main(String[] args) {
        T001_CreateThread t = new T001_CreateThread();
        //t.run(); // 直接调用run()方法，不会启动新的线程
        t.start(); // 启动新线程，使用start()方法
        // 获取线程，线程池中获取线程，就是用Runable
        new Thread(new MyRunable()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "====>" + i);
        }
    }

}
