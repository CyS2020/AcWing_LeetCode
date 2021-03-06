package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/4
 * 描述：深度优先搜索
 * 口诀：终止条件+恢复现场
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
            if (!col[j] && !dig[n + j - u] && !udig[j + u]) {
                col[j] = dig[n + j - u] = udig[j + u] = true;
                chess[u][j] = 'Q';
                dfs(u + 1);
                chess[u][j] = '.';
                col[j] = dig[n + j - u] = udig[j + u] = false;
            }
        }
    }
}
