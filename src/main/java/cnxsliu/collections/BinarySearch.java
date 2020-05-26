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
     * 使用循环
     * 》》mid = lo + (hi - lo) / 2;可以防止直接相加内存溢出
     * @param array
     * @param target
     * @return
     */
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) >> 1;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
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
