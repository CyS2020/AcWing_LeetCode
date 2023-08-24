package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/4
 * 描述： n-皇后问题
 * 口诀：深度优先搜索：终止条件+恢复现场
 * 使用截距表示两个对角线
 * 正对角线：y = x + b; b = y - x;
 * 斜对角先：y = -x + b; b = x + y;
 */
public class NQueen {

    public static int n;

    public static boolean[] col;

    public static boolean[] dig;

    public static boolean[] udig;

    public static char[][] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        n = Integer.parseInt(line);
        col = new boolean[n];
        dig = new boolean[n * 2];
        udig = new boolean[n * 2];
        chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }
        dfs(0);
    }

    public static void dfs(int u) {
        if (u >= n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(chess[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int j = 0; j < n; j++) {
            int b = j - u + n;
            int ub = j + u;
            if (!col[j] && !dig[b] && !udig[ub]) {
                chess[u][j] = 'Q';
                col[j] = true;
                dig[b] = true;
                udig[ub] = true;
                dfs(u + 1);
                udig[ub] = false;
                dig[b] = false;
                col[j] = false;
                chess[u][j] = '.';
            }
        }
    }
}
