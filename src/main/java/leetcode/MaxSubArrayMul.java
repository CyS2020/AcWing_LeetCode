package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/9/19
 * 描述：乘积最大子数组
 * 思路：遍历某个位置时, 该值要么乘上最大值, 乘上最小值, 或者不乘
 */
public class MaxSubArrayMul {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i] * min, nums[i] * tmp), nums[i]);
            min = Math.min(Math.min(nums[i] * min, nums[i] * tmp), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
