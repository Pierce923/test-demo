package cc.fivelong.t03_instructions;

/**
 * 递归指令详解
 */
public class T_04_Recursion {

    public static void main(String[] args) {
        T_04_Recursion t = new T_04_Recursion();
        t.m(4);
    }

    public int m(int n){
        if (n==1) {
            return 1;
        }
        System.out.println(n);
        return m(n-1);
    }

}
