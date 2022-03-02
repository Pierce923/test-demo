package cc.fivelong.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 计数排序
 * 适用于量大而范围小，
 * 基本思想：就是把数组元素作为数组的下标，然后用一个临时数组统计该元素出现的次数，
 * 例如 temp[i] = m, 表示元素 i 一共出现了 m 次。最后再把临时数组统计的数据从小到大汇总起来，此时汇总起来是数据是有序的。
 * 题目：
 * 将分数对名次进行排序
 */
public class T004_CountSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(150);
        }

        // 计数数组
        int[] countArr = new int[150];

        // 根据分数，计数数组相应值+1
        for (int i = 0; i < arr.length; i++) {
            int score = arr[i];
            countArr[score]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < countArr.length; i++) {
            int value = countArr[i];
            if (value > 0) {
                for (int j = 0; j < value; j++) {
                    list.add(i);
                }
            }
        }

        // 结果打印
        if (list.size() > 0) {
            for (Integer socre : list) {
                System.out.println("socre-->" + socre);
            }
        }
    }

}
