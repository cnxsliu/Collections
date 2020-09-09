package cnxsliu.collections.sort;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/10 21:11
 * @strategy 快速排序
 * >> 共 24 行
 * >> 注意：i = left + 1
 */
public class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int value = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < value) {
                int temp = nums[i];
                nums[i] = nums[j + 1];
                nums[j + 1] = temp;
                j++;
            }
        }
        nums[left] = nums[j];
        nums[j] = value;
        return j;
    }

    public static void main(String[] arr) {
        QuickSort sort = new QuickSort();
        int[] nums = {9,8,0,7,6,5,4,0,3,2,1};
        sort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
