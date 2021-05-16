package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/16
 * 描述：顺时针打印数组
 * 思路：撞了南墙就拐弯
 */
public class SpiralOrder {

    int[] dx = {-1, 0, 1, 0};

    int[] dy = {0, 1, 0, -1};

    boolean[][] st;

    int[][] matrix;

    int row, col, id = 0, direct = 1;

    int[] res;

    public int[] spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        this.col = matrix[0].length;
        this.st = new boolean[row][col];
        this.res = new int[row * col];

        dfs(0, 0);
        return res;
    }

    public void dfs(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || st[x][y]) {
            return;
        }

        st[x][y] = true;
        res[id++] = matrix[x][y];
        int a = x + dx[direct];
        int b = y + dy[direct];
        if (a < 0 || a >= row || b < 0 || b >= col || st[a][b]) {
            direct = (direct + 1) % 4;
            a = x + dx[direct];
            b = y + dy[direct];
        }
        dfs(a, b);
    }
}
