package cc.fivelong.thread.exercise.t01_consumer;

/**
 * 货物
 */
public class Gods {

    private String brand;

    private String name;

    private boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 消费者
    public synchronized void get() {
        // 消费者抢占CPU后，先判断是否有货物 是：进行消费  否：进入阻塞状态
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了：" + this.getName() + "-" + this.getBrand());
        this.flag = false;
        // 唤醒阻塞线程
        notify();
    }

    public synchronized void set(String brand, String name) {
        // 生产者抢占CPU后，先判断货物是否已被消费  是：进行生产 否：进入阻塞状态
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        this.setBrand(brand);
        this.flag = true;
        // 唤醒阻塞线程
        notify();
    }

}
