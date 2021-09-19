package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/4
 * 描述：排列数字
 * 口诀：深度优先搜索：终止条件+恢复现场
 */
public class ArrangeNum {

    public static int n;

    public static int[] arr;

    public static boolean[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        n = Integer.parseInt(line);
        arr = new int[n + 1];
        st = new boolean[n + 1];
        dfs(1);
    }

    public static void dfs(int u) {
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                arr[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}
