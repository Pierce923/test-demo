package cc.fivelong.thread;

/**
 * Thread类的api
 */
@SuppressWarnings("all")
public class T001_ThreadApiDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
        System.out.println("线程名-->"+t1.getName());
        System.out.println("线程ID-->"+t1.getId());
        System.out.println("优选级-->"+t1.getPriority());
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }

        T001_ThreadApiDemo threadApiDemo = new T001_ThreadApiDemo();
        Thread t2 = new Thread(threadApiDemo);
        System.out.println("线程名-->"+t2.getName());
        System.out.println("线程ID-->"+t2.getId());
        System.out.println("优选级-->"+t2.getPriority());
        /**
         * 设置线程池的优先级
         * 优先级越高，一定先执行吗？不一定，只是优先执行概率大一些。
         */
        t2.setPriority(10);
        System.out.println("优选级-->"+t2.getPriority());

        System.out.println("是否存活-->"+t2.isAlive());
        t2.start();
        System.out.println("启动线程");
        System.out.println("是否存活-->"+t2.isAlive());
    }
}
