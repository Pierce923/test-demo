package cc.fivelong;

/**
 * IntegerCache是Integer的内部类
 * 把-128~127的数字缓存起来了，用于提升性能和节省内存。
 */
public class T005_IntegerCache {

    public static void main(String[] args) throws Exception {
        Integer n1 = 123;
        Integer n2 = 123;
        Integer n3 = 128;
        Integer n4 = 128;

        System.out.println(n1 == n2);
        System.out.println(n3 == n4);
    }

}
