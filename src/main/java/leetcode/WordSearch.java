package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述：单词搜索
 * 思路：枚举每个起点的位置进行dfs
 */
public class WordSearch {

    private final int[] dx = {-1, 0, 1, 0};

    private final int[] dy = {0, 1, 0, -1};

    private boolean[][] st;

    private char[][] board;

    private String word;

    private int row, col;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.st = new boolean[row][col];
        this.board = board;
        this.word = word;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int idx) {
        st[x][y] = true;
        if (board[x][y] == word.charAt(idx)) {
            if (idx == word.length() - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && b >= 0 && a < row && b < col && !st[a][b]) {
                    if (dfs(x + dx[i], y + dy[i], idx + 1)) {
                        return true;
                    }
                }
            }
        }
        st[x][y] = false;
        return false;
    }
}
