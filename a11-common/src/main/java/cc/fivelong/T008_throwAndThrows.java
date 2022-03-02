package cc.fivelong;

/**
 * throw 抛出异常
 * throws 抛出异常声明，让上层方法解决
 */
public class T008_throwAndThrows {

    public static void main(String[] args) {
        throwTest();
//        throwsTest();
    }

    // throws 处理声明异常
    private static void throwsTest() {
        try {
            throwsTest2();
        } catch (Exception e) {
            System.out.println("throws 异常");
        }
    }

    // throws 抛出异常的声明，交给上层调用方法处理
    private static void throwsTest2() throws Exception {
        String a = "aaa";
        System.out.println(Double.valueOf(a));
    }

    // throw抛出异常
    private static void throwTest() {
        String a = "aaa";
        if ("aaa".equals(a)) {
            // throw 抛出一个异常
            throw new NumberFormatException();
        } else {
            System.out.println(a);
        }
    }

}
