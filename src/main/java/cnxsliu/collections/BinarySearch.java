package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/21 19:55
 * @strategy 二分查找，升序数组
 * >> mid 加一还是减一，while 里到底用 <= 还是 <
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
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 使用递归
     * @param array
     * @param lo
     * @param hi
     * @param target
     * @return
     */
    public int binarySearchWithRecursion(int[] array, int lo, int hi, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] > target) {
            return binarySearchWithRecursion(array, lo, mid - 1, target);
        } else {
            return binarySearchWithRecursion(array, mid + 1, hi, target);
        }
    }
}
