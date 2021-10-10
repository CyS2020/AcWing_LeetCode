package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：买卖股票的最佳时机II
 * 思路：维护最小值即可
 */
public class StockMaxProfitII {

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
