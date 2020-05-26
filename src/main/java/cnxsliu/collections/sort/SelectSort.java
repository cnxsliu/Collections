package cnxsliu.collections.sort;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 20:11
 * @strategy
 */
public class SelectSort {
    public void selectSort(int[] nums) {
        int min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] arr) {
        SelectSort sort = new SelectSort();
        int[] nums = {9,8,0,7,6,5,4,0,3,2,1};
        sort.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
