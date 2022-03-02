package cc.fivelong.sorting;

/**
 * 选择排序
 * 1.选取下标0,与后面下标的值向比较，选出最小值
 * 2.将最小值的下标与0的下标交换位置
 */
public class T001_SelectSort {

    public static void main(String[] args) {

        int[] array = {6, 4, 5, 9, 23, 55, 85, 24};

        selectSorting(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private static void selectSorting(int[] array) {
        // 获取array中下标n
        // n与array其它值(下标大于n)比较大小，小：继续比较     大：交换值，继续比较，直到找到最小值的下标
        // 将下标n的值赋值为最小值
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            // 比较的值必须是i+1下标的值开始
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            // 如果minIndex被替换，修改下标i的值
            if (minIndex != i) {
                int swap = array[i] ^ array[minIndex];
                array[i] = swap ^ array[i];
                array[minIndex] = swap ^ array[i];
            }
        }
    }

}
