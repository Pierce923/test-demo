package cc.fivelong.thread.t011_hashtable_to_chm;

import java.util.Hashtable;

public class T001_HashTable {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("111", "111");
        hashtable.put("222", "222");
        System.out.println(hashtable.size());
    }

}
