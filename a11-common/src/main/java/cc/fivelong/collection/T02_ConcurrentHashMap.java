package cc.fivelong.collection;

import java.util.concurrent.ConcurrentHashMap;

public class T02_ConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("aa", "aa");

        map.get("aa");
    }

}
