package cc.fivelong.collection;

import java.util.Hashtable;

/**
 * HashTable是线程安全的
 * put()/get()使用的synchronized
 */
public class T04_HashTable {

    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>();
        table.put("a", "a");
    }

}
