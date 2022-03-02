package cc.fivelong;

/**
 * Long类型
 */
public class T007_Long {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    // LongCache保存-128~127的值
    private static void test2() {
        Long a = 127L;
        Long b = 127L;
        System.out.println(a == b);
        Long c = 128L;
        Long d = 128L;
        System.out.println(c == d);
    }

    private static void test1() {
        Long a = new Long(100L);
        Long b = new Long(100L);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

}
