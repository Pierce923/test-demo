package cc.fivelong;

/**
 * continue跳出本次循环，不继续执行后面的语句，继续执行下次循环
 */
public class T010_Continue {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("i循环=====》" + i);
            for (int j = 0; j < 5; j++) {
                if (j == 2) {
                    System.out.println("循环-->" + j);
                    // continue跳出本次循环，不继续执行后面的语句，继续执行下次循环
                    continue;
                }
                System.out.println("循环------------>" + j);
            }
        }
    }

}
