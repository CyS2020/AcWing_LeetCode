package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/5/30
 * 描述：最大子数组
 * 思路：遍历某个位置时, 该值要么加上前面的和要么不加
 */
public class MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}