package cc.fivelong.thread.t011_hashtable_to_chm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class T003_SynchronizedHashMap {

    public static void main(String[] args) {
        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
        map.put("111", "111");
        map.put("222", "222");
        System.out.println(map.size());
    }

}
