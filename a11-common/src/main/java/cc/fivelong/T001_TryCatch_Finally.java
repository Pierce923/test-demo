package cc.fivelong;

import java.util.ArrayList;
import java.util.List;

/**
 * try-catch-finally
 */
public class T001_TryCatch_Finally {

    public static void main(String[] args) {
        System.out.println(m1());
        System.out.println("------------------------------------");
        System.out.println(m2());
        System.out.println("------------------------------------");
        System.out.println(m3());
    }

    /**
     * try中带有return，执行中会先保存return信息，
     * 再执行finally，最后通过return返回之前保存的信息
     */
    static Integer m1() {
        int i = 1;
        try {
            i++;
            System.out.println("try---" + i);
            return i;
        } catch (Exception e) {
            System.out.println("ex");
        } finally {
            i++;
            System.out.println("finally---" + i);
        }
        return i;
    }

    /**
     * catch中带有return，执行中会先保存return信息
     * 再执行finally，最后通过return返回之前保存的信息
     */
    static int m2() {
        int i = 1;
        try {
            i++;
            System.out.println("try---" + i);
            int a = 1 / 0;
        } catch (Exception e) {
            i++;
            System.out.println("ex----" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally---" + i);
        }
        return i;
    }

    /**
     * m1和m2使用的是基本类型，而m3中使用的list是引用类型，引用类型值修改，
     * return只是记录内存，因此会影响返回值。
     */
    static Integer m3() {
        List<Integer> list = new ArrayList<Integer>(7);
        int i = 1;
        try {
            i++;
            list.add(i);
            System.out.println("try----" + list.toString());
            return i;
        } catch (Exception e) {

        } finally {
            i++;
            list.add(i);
            System.out.println("finally----" + list.toString());
        }
        return i;
    }

}
