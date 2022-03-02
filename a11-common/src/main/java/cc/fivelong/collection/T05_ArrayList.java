package cc.fivelong.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayList
 * 可以存储异构对象
 * 长度可变
 */
public class T05_ArrayList {

    private static final ArrayList<String> alist = new ArrayList<String>();

    public static void main(String[] args) {
        //m1();
//        m2();
//        m3();
        m4();
    }

    static {
        alist.add("aa");
        alist.add("bb");
        alist.add("cc");
        alist.add("dd");
    }

    // arraylist中的listIterator
    private static void m4() {
        ListIterator<String> listIterator = alist.listIterator();
        listIterator.add("ee");
        listIterator.add("rr");
        System.out.println(alist.toString());
    }

    // arraylist是数组结构，remove()之后，元素会向前移动一位，for循环会保存：java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
    private static void m2() {
        for (; ; ) {
            alist.remove(2);
        }
    }

    // 通过迭代器iterator删除，迭代器的remove()与arrayList的remove()不一样
    private static void m3() {
        Iterator<String> iterator = alist.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("cc")) {
                iterator.remove();
                System.out.println("remove-->" + next);
            }
        }
        System.out.println(alist.toString());
    }

    // arraylist可以保存不同数据类型的对象
    private static void m1() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add("aa");
        list.add(1111);
    }

}
