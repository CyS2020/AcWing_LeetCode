package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/10
 * 描述：完全平方数
 * 思路：动态规划
 */
public class NumSquares {

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, f[i - j * j]);
            }
            f[i] = min + 1;
        }
        return f[n];
    }
}
