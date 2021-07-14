package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/13
 * 描述：n个骰子的点数
 * 思路：求出每种组合的方案dp，然后除以总的组合
 */
public class DiceProbability {

    public double[] dicesProbability(int n) {
        double all = Math.pow(6, n);
        int[][] f = new int[n + 1][6 * n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6 * n; j++) {
                for (int k = 1; k <= Math.min(j, 6); k++) {
                    f[i][j] += f[i - 1][j - k];
                }
            }
        }

        double[] res = new double[5 * n + 1];
        for (int i = 0, j = n; j <= 6 * n; j++, i++) {
            res[i] = f[n][j] / all;
        }
        return res;
    }
}
