package cc.fivelong.sorting;

public class T003_InsertionSort {

    public static void main(String[] args) {
        int[] arr = {11, 3, 2, 5, 9, 8, 6};

        for (int i = 1; i < arr.length; i++) {
            // 比较并交换
            CompareAndSwap(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void CompareAndSwap(int[] arr, int i) {
        for (int j = i; j > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
