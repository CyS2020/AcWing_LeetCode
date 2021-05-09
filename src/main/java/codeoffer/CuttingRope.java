package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/9
 * 描述：剪绳子
 * 思路：可以将问题转为完全背包问题，剪绳子转为拼接绳子
 */
public class CuttingRope {

    // 完全背包思路
    public int cuttingRope1(int n) {
        int[][] f = new int[n + 1][n + 1];

        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k * i <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - i * k] * (int) Math.pow(i, k));
                }
            }
        }
        return f[n - 1][n];
    }

    // 数学思路
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        if (n % 3 == 1) {
            res = 4;
            n -= 4;
        } else if (n % 3 == 2) {
            res = 2;
            n -= 2;
        }
        while (n != 0) {
            n -= 3;
            res *= 3;
        }
        return res;
    }
}
