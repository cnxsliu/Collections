package cnxsliu.collections.Sort;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 19:41
 * @strategy
 */
public class BubbltSort {
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

}
