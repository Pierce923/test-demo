package cc.fivelong;

public class T002_String {

    public static void main(String[] args) {
//        m2();
//        m1();
//        m3();
//        test7();
    }

    // a变量中，连接b变量，使用了StringBuilder
    private static void test7() {
        String b = "ee";
        String a = "aa" + "bb" + b;
        System.out.println(a);
    }
    
    // a和b的值是同一个
    private static void m3() {
        String a = new String("aa");
        String b = new String("aa");
        System.out.println(a == b);
    }

    // String连接，是创建一个新的char[]数组
    private static void m2() {
        String a = "a" + "b";
    }

    // 常量池存在的数据，实例引用指向是一致的
    private static void m1() {
        String b = "zxcv";
        String c = "zxcv";
        System.out.println(b == c);
    }

}
