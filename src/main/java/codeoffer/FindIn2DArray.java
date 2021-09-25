package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/9/25
 * 描述：
 */
public class FindIn2DArray {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / col][mid % col] >= target) {
                r = mid;
            } else if (matrix[mid / col][mid % col] < target) {
                l = mid + 1;
            }
        }
        return matrix[r / col][r % col] == target;
    }
}
