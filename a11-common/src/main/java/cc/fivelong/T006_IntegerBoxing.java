package cc.fivelong;

/**
 * Integer自动装箱和自动拆箱
 */
public class T006_IntegerBoxing {

    public static void main(String[] args) {
        // 系统自动执行 Integer a = Integer.valueOf(100)
        Integer a = 100;

        // 自动拆箱 int c = b.intValue();
        Integer b = 100;
        int c = b;
    }

}
