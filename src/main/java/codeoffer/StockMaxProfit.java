package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/16
 * 描述：股票的最大利润
 * 口诀：维护一个最小值即可
 */
public class StockMaxProfit {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }
        return res;
    }
}
