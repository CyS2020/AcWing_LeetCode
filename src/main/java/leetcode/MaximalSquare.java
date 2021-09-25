package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/6/16
 * 描述：最大正方形
 * 思路：相邻的最小值决定了该位置的值
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] f = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }
                maxLen = Math.max(maxLen, f[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
