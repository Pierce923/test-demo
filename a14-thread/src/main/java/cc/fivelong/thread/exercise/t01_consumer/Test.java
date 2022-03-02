package cc.fivelong.thread.exercise.t01_consumer;

public class Test {

    public static void main(String[] args) {
        Gods gods = new Gods();

        Produer produer = new Produer(gods);
        Consumer consumer = new Consumer(gods);

        Thread t1 = new Thread(produer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }

}
