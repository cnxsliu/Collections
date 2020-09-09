package cnxsliu.collections.sort;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/10 19:56
 * @strategy 归并排序
 * >> 共 35 行
 * >> 注意：k <= right
 * >> 注意：j - right
 * >> 注意：temp[i - left] < temp[j - left]
 * >> 注意：第一个条件判断，temp[j - left]
 */
public class MergeSort {
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        if (nums[middle] > nums[middle + 1]) {
            merge(nums, left, middle, right);
        }
    }

    private void merge(int[] nums, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            temp[i - left] = nums[i];
        }
        int i = left;
        int j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                nums[k] = temp[j - left];
                j++;
            } else if (j > right) {
                nums[k] = temp[i - left];
                i++;
            } else if (temp[i - left] < temp[j - left]) {
                nums[k] = temp[i - left];
                i++;
            } else {
                nums[k] = temp[j - left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {9,8,0,7,6,5,4,0,3,2,1};
        sort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
