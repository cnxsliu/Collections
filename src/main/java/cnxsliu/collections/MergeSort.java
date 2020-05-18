package cnxsliu.collections;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/10 19:56
 * @strategy 归并排序
 */
public class MergeSort {
    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) >> 1;
        sort(arr, left, middle);
        sort(arr, middle + 1, right);
        merge(arr ,left, middle, right);
    }

    /**
     * 将一个数组的两个已经排好序的部分合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr , int left, int mid , int right) {
        //定义一个临时数组来存储数组中的元素
        int[] temp  = new int[right - left +1];
        for (int i = left; i <= right; i++) {
            temp[i - left] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            //分 4 种情况来讨论
            if (i > mid) {
                arr[k] = temp[j - left];
                j++;
            } else if(j > right){
                arr[k] = temp[i - left];
                i++;
            } else if (temp[i - left] < temp[j - left]) {
                arr[k] = temp[i - left];
                i++;
            } else{
                arr[k] = temp[j - left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,7,8,3,1,6,9,0,5,4,11,23,12,43,15,22,66,34,28};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
