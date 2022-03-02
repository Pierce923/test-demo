package cc.fivelong.sorting;

public class T002_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 9, 8, 6};

        for (int j = arr.length - 1; j > 0; j--) {
            // 先获取最大值，放置在最后位
            findMax(arr, j);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 先获取最大值，放置在最后位
     */
    private static void findMax(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


}
