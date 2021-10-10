package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/10/10
 * 描述：最佳买卖股票时机含冷冻期
 * 思路：动态规划
 * f[i][0]=持有，之前就有 或 今天买的
 * f[i][1]=冷冻，今天卖的
 * f[i][2]=不持有，之前就没有 或 昨天卖的
 * f[0][0]初始值表示没钱, 借钱今天刚买的
 */
public class StockMaxProfitIII {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] f = new int[len][3];

        f[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            f[i][0] = Math.max(f[i - 1][0], (f[i - 1][2] - prices[i]));
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[len - 1][1], f[len - 1][2]);
    }
}
