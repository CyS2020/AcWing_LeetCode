package leetcode;

import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/10/25
 * 描述：零钱兑换
 * 思路：完全背包
 */
public class BinPackingTotalII {

    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int V = amount;
        int[][] f = new int[N + 1][V + 1];
        Arrays.stream(f).forEach(arr -> Arrays.fill(arr, V + 1));
        f[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                for (int k = 0; k * coins[i - 1] <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - k * coins[i - 1]] + k);
                }
            }
        }
        return f[N][V] > V ? -1 : f[N][V];
    }
}
