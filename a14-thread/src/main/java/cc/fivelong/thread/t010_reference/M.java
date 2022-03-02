package cc.fivelong.thread.t010_reference;

public class M {

    @Override
    public void finalize() throws Throwable {
        System.out.println("finalize");
    }

}
