package leetcode;

import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/10/25
 * 描述：分割等和子集
 * 思路：01背包
 */
public class BinPackingOneII {

    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int V = Arrays.stream(nums).reduce(0, Integer::sum);
        if (V % 2 == 1) {
            return false;
        }
        V = V / 2;

        boolean[][] f = new boolean[N + 1][V + 1];
        Arrays.stream(f).forEach(arr -> Arrays.fill(arr, false));
        f[0][0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                f[i][j] |= f[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    f[i][j] |= f[i - 1][j - nums[i - 1]];
                }
            }
        }
        return f[N][V];
    }
}
