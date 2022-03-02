package cc.fivelong;

/**
 * return：return的功能是结束一个方法
 * return不管有多个的循环，都直接结束。
 */
public class T011_Return {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("循环========================>" + i);
            for (int j = 0; j < 5; j++) {
                System.out.println("J循环--->" + j);
                if (j == 2) {
                    System.out.println("J---------->" + j);
                    return;
                }
            }
        }
    }

}
