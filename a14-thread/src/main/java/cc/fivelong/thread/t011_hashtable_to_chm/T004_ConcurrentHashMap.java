package cc.fivelong.thread.t011_hashtable_to_chm;

import java.util.concurrent.ConcurrentHashMap;

public class T004_ConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("111", "111");
        map.put("222", "222");
        System.out.println(map.size());
    }
    
}
