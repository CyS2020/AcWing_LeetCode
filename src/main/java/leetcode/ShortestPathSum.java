package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/8/29
 * 描述：最小路径和
 * 思路：简单的动态规划
 */
public class ShortestPathSum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] f = new int[n][m];
        f[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                }
            }
        }
        return f[n - 1][m - 1];
    }
}
