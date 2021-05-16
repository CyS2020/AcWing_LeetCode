package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/7
 * 描述：矩阵中的路径
 */
public class MatrixPath {

    char[][] board;

    String word;

    boolean[][] state;

    int row, col;

    int[] dx = {-1, 0, 1, 0};

    int[] dy = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        this.word = word;
        this.state = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                state[i][j] = true;
                if (dfs(i, j, 0)) {
                    return true;
                }
                state[i][j] = false;
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int k) {
        if (board[x][y] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < row && b >= 0 && b < col && !state[a][b]) {
                state[a][b] = true;
                if (dfs(a, b, k + 1)) {
                    return true;
                }
                state[a][b] = false;
            }
        }
        return false;
    }
}
