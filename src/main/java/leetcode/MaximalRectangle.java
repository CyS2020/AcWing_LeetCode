package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述：最大矩形
 * 思路：最大柱状图面积的二维版本，在宽度确定的情况下寻找高度最大值
 * 对于每一行，使用基于柱状图的方法 循环内直接复制 柱状图的代码，把i改为j就可以使用了
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] up = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    up[i][j] = (i == 0 ? 0 : up[i - 1][j]) + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) { // 对于每一行，使用基于柱状图的方法
            int[] left = new int[col];
            int[] right = new int[col];
            Arrays.fill(right, col - 1);

            Deque<Integer> stack = new LinkedList<>();
            for (int j = 0; j < col; j++) {
                while (!stack.isEmpty() && up[i][j] <= up[i][stack.peekLast()]) {
                    right[stack.pollLast()] = j - 1;
                }
                left[j] = stack.isEmpty() ? 0 : stack.peekLast() + 1;
                stack.addLast(j);
            }

            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, (right[j] - left[j] + 1) * up[i][j]);
            }
        }
        return ans;
    }
}
