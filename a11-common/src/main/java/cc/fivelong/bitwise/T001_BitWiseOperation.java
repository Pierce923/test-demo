package cc.fivelong.bitwise;

/**
 * & 与
 * | 或
 * ~ 取反
 * ^ 异或 -- 当两两数值相同为否，而数值不同时为真。 哲学中：否定的否定是肯定
 * >> 右移位
 * << 左移位 正整数 左移位n，就是2的(n+1)次幂
 * >>> 无符号右移位
 */
@SuppressWarnings("all")
public class T001_BitWiseOperation {

    public static void main(String[] args) {

        // 异或
        xor();
        // 左移位
        int a = 2 << 2;
        System.out.println("左移位-->" + a);
    }

    /**
     * 异或
     */
    static void xor(){
        int a = 3;
        int b = 5;
        a = a ^ b; // a xor b
        // a xor b xor b = a
        b = a ^ b;
        // a xor b xor a = b
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

    }

}
