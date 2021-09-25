package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/6
 * 描述：搜索二维矩阵
 * 思路：从右上角进行查找，大于目标值往左，小于目标值往下
 */
public class FindIn2DArrayII {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}
