package chapter5;

/**
 * @author: CyS2020
 * @date: 2021/10/10
 * 描述：合并气球
 * 思路：区间dp, 类似于合并石子
 * k 可以理解成[l, r]范围里最后戳破的一个气球
 */
public class MergeBalloons {

    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] arr = new int[N + 2];
        arr[0] = arr[N + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, N);

        int[][] f = new int[N + 2][N + 2];
        for (int len = 1; len <= N; len++) {
            for (int l = 1; l <= N - len + 1; l++) {
                int r = l + len - 1;
                for (int k = l; k <= r; k++) {
                    f[l][r] = Math.max(f[l][r], f[l][k - 1] + arr[l - 1] * arr[k] * arr[r + 1] + f[k + 1][r]);
                }
            }
        }
        return f[1][N];
    }
}
