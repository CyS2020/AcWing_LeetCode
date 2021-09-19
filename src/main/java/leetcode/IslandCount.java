package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/9/19
 * 描述：岛屿数量
 * 思路：dfs
 */
public class IslandCount {

    private final int[] dx = {-1, 0, 1, 0};

    private final int[] dy = {0, 1, 0, -1};

    private int row, col;

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        boolean[][] st = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !st[i][j]) {
                    res++;
                    dfs(i, j, grid, st);
                }
            }
        }
        return res;
    }

    public void dfs(int x, int y, char[][] grid, boolean[][] st) {
        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < row && b >= 0 && b < col && !st[a][b] && grid[a][b] == '1') {
                dfs(a, b, grid, st);
            }
        }
    }
}
