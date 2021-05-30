package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/30
 * 描述：最大子数组的和
 * 思路：f[i]左右以i结尾的最大子序列和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            if (f[i - 1] < 0) {
                f[i] = nums[i - 1];
            } else {
                f[i] = f[i - 1] + nums[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
}