package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/9/26
 * 描述：除自身以外数组的乘积
 * 思路：两次动态规划
 */
public class ExSelfArrayMul {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int mul = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * mul;
            mul *= nums[i];
        }
        return ans;
    }
}
