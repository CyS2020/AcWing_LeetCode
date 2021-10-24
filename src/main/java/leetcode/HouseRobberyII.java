package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/24
 * 描述：打家劫舍
 */
public class HouseRobberyII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] f1 = new int[len];
        f1[0] = nums[0]; // 0 ~ n-1
        f1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            f1[i] = Math.max(f1[i - 1], f1[i - 2] + nums[i]);
        }

        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] f2 = new int[len];
        f2[1] = nums[1]; // 1 ~ n
        f2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < len; i++) {
            f2[i] = Math.max(f2[i - 1], f2[i - 2] + nums[i]);
        }
        return Math.max(f1[len - 2], f2[len - 1]);
    }
}
