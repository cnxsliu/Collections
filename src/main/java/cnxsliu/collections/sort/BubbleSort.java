package cnxsliu.collections.sort;

import java.util.Arrays;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 19:41
 * @strategy
 */
public class BubbleSort {
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] arr) {
        BubbleSort sort = new BubbleSort();
        int[] nums = {9,8,7,6,5,4,3,2,1};
        sort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
