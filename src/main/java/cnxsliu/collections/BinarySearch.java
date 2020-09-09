package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/21 19:55
 * @strategy 二分查找，升序数组
 * >> 数组非空判断
 * >> while 里用 <=
 * >> int mid = left + (right - left) >> 1;
 * >> mid + 1，mid - 1
 */
public class BinarySearch {
    /**
     * 使用循环，共 18 行
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(bs.binarySearch(nums, 1));
    }

    /**
     * 使用递归
     * @param array array
     * @param left left
     * @param right right
     * @param target target
     * @return
     */
    private int binarySearchWithRecursion(int[] array, int left, int right, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int mid = left + (right - left) >> 1;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] > target) {
            return binarySearchWithRecursion(array, left, mid - 1, target);
        } else {
            return binarySearchWithRecursion(array, mid + 1, right, target);
        }
    }
}
