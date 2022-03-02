package cc.fivelong;

/**
 * Integer测试
 * 参考文档：https://www.cnblogs.com/yanggb/p/10727092.html
 */
public class T004_Integer {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {
        Integer a = 100;
        Integer b = 100;
        Integer c = 128;
        Integer d = 128;
        // 对于两个非new生成的Integer对象，进行比较时，如果两个变量的值在区间-128到127之间，则比较结果为true；如果两个变量的值不在此区间，则比较结果为false。
        System.out.println(a == b);
        System.out.println(c == d);
    }


    private static void test3() {
        Integer a = new Integer(100);
        Integer b = 100;
        System.out.println(a == b);// false 两个对象的内存地址不一致
    }

    private static void test1() {
        Integer a = 200;
        Integer b = 200;
        // a、b的值是相等的
        System.out.println("equals-->" + a.equals(b));
        // a、b是两个对象 ==比较的是内存地址
        System.out.println("a==b-->" + (a == b));
    }

    private static void test2() {
        Integer a = 200;
        // Integer变量和int变量比较时，只要两个变量的值是相等的，则结果为true（包装类Integer和基本数据类型int比较的时候，Java会自动拆箱为int，然后进行比较，实际上就变为两个int变量的比较）
        int c = 200;
        System.out.println("int == -->" + (a == c));

    }

}
