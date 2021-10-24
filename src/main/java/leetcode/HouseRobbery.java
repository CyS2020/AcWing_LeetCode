package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/9/19
 * 描述：打家劫舍
 * 思路：
 */
public class HouseRobbery {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] f = new int[len];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[len - 1];
    }
}