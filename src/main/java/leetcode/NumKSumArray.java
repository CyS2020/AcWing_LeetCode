package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/27
 * 描述：和为 K 的子数组
 * 思路：前缀和 + 枚举所有的区间(非优解)
 */
public class NumKSumArray {

    public int subArraySum(int[] nums, int k) {
        int res = 0;
        int N = nums.length;
        int[] sums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int len = 1; len <= N; len++) {
            for (int l = 1; l <= N - len + 1; l++) {
                int r = l + len - 1;
                if (sums[r] - sums[l - 1] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
