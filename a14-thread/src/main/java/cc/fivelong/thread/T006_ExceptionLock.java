package cc.fivelong.thread;

/**
 * 程序在执行过程中，如果出现异常，锁会被释放。
 * 如果有多个线程竞争同一个资源，第一个线程执行中，出现异常，锁被释放，但是线程1修改的变量没有被回退，就会被其它线程读取到，因此出现数据异常。
 * 因此需要注意到同步业务逻辑中的异常。
 */
public class T006_ExceptionLock {

    int count = 0;

    synchronized void m(){
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName() + "-->" + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 3/0;
                System.out.println(Thread.currentThread().getName() + "异常");
            }
        }
    }


    public static void main(String[] args) {
        // 必须new同一个对象
        T006_ExceptionLock t = new T006_ExceptionLock();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "t1").start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "LLLLLLLL2").start();
        //new T006_ExceptionLock().m();
    }

}
