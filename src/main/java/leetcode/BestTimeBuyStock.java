package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：买卖股票的最佳时机
 * 思路：维护最小值即可
 */
public class BestTimeBuyStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            if (price > minPrice) {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
