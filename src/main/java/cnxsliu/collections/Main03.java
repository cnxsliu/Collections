package cnxsliu.collections;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/10 16:06
 * @strategy
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            min = Math.min(nums[i] + nums[nums.length - i - 1],min);
            max = Math.max(nums[i] + nums[nums.length - i - 1],max);
        }
        System.out.println(max - min);
    }
}
