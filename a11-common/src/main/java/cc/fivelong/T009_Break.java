package cc.fivelong;

/**
 * break 跳出当前循环，有多层循环嵌套时，只是跳出当前循环
 */
public class T009_Break {

    public static void main(String[] args) {

//        breakTest();
        breakTest2();

    }

    // break 跳出当前循环体
    private static void breakTest2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i循环-->" + i);
            for (int j = 0; j < 6; j++) {
                if (j == 2) {
                    System.out.println("J-->" + j);
                    break;
                }
                System.out.println("J 循环-->" + j);
            }
        }
    }

    private static void breakTest() {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                System.out.println("跳出循环-->" + i);
                break;
            }
            System.out.println("循环--->" + i);
        }
    }

}
