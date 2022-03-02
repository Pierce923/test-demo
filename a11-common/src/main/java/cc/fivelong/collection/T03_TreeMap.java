package cc.fivelong.collection;

import java.util.*;

/**
 * TreeMap 排序
 * TreeMap默认是升序的，如果我们需要改变排序方式，则需要使用比较器：Comparator。
 */
public class T03_TreeMap {

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        map.put("aaa", "aaa");
        map.put("bbb", "bbb");
        map.put("ccc", "ccc");
        map.put("ddd", "ddd");
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }
    }

}
