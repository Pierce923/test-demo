package cc.fivelong.t04_loadclass;

public class T_04_Loading {

    public static void main(String[] args){
        /*P p;
        System.out.println("I-->"+P.i);
        System.out.println("J-->"+P.j);*/
        V v = new V();
    }

    public static class P {
        final static int i = 1;
        static int j = 2;
        static {
            System.out.println("P loading");
        }
    }

    // 初始化子类的时候，父类首先初始化
    public static class V extends P {
        static {
            System.out.println("X loading");
        }
    }

}
