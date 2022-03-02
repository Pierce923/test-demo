package cc.fivelong.t04_loadclass;

/**
 * 解释器和编译器区别
 * -Xmixed:混合模式
 * -Xint:使用解释模式，启动很快执行很慢
 * -Xcomp:使用纯编译模式，执行很快，编译很慢
 */
public class T_05_WayAndRun {

    public static void main(String[] args){
        for (int i = 0; i < 100000; i++) {
            m();
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(10_0000L);
    }

    public static void m(){
        for (int i = 0; i < 100000L; i++) {
            long j = i%2;
        }
    }

}
