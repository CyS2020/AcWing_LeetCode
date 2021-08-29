package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/8/29
 * 描述：最大子序和
 * 思路：只要不是sum不是负数就继续加, 最后判断负数
 */
public class MaxSubSeqSum {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
