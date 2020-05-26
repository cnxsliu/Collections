package cnxsliu.collections.sort;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 20:24
 * @strategy
 */
public class InsertSort {
    public void insertSort(int[] nums) {
        int index, current;
        for (int i = 0; i < nums.length; i++) {
            index = i - 1;
            current = nums[i];
            while (index >= 0 && nums[index] > current) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = current;
        }
    }

    public static void main(String[] arr) {
        InsertSort sort = new InsertSort();
        int[] nums = {9,8,0,7,6,5,4,0,3,2,1};
        sort.insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
