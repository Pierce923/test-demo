package cc.fivelong.thread.exercise.t01_consumer;

public class Produer implements Runnable {

    private Gods gods;

    public Produer(Gods gods) {
        this.gods = gods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                gods.set("蛙哈哈" + i, "矿泉水" + i);
            } else {
                gods.set("麻辣王子" + i, "辣条" + i);
            }
            System.out.println("生产了-->" + i + "-->" + gods.getName() + "-" + gods.getBrand());
        }
    }


}
