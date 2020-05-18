package cnxsliu.collections;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/10 21:11
 * @strategy 快速排序
 */
public class QuickStart {
    private static void quickSort(int[] arr, int left,int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int value = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            //左边是小于 value，右边是大于等于 value
            if (arr[i] < value) {
                swap(arr, i , j + 1);
                j++;
            }
        }
        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,34,23,1,2,3,24,4,5,2,7,9,8,21,14,15,20,19,18};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
