package leetcode;

import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/10/26
 * 描述：目标和
 */
public class NumSumCount {

    private int res = 0;

    public int findTargetSumWaysDfs(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return res;
    }

    private void dfs(int[] nums, int index, int target, int sum) {
        if (nums.length == index) {
            if (sum == target) {
                res++;
            }
            return;
        }
        dfs(nums, index + 1, target, sum - nums[index]);
        dfs(nums, index + 1, target, sum + nums[index]);
    }

    /**
     * f[i][j]所有总前i个选总体积为j的选法
     * (sum−neg)−neg=sum−2⋅neg=target
     * 加的和 - 减的和 = target
     */
    public int findTargetSumWaysDp(int[] nums, int target) {
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int neg = diff / 2;
        int len = nums.length;
        int[][] f = new int[len + 1][neg + 1];
        f[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= num) {
                    f[i][j] += f[i - 1][j - num];
                }
            }
        }
        return f[len][neg];
    }
}
