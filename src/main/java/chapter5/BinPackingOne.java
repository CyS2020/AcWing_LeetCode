package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：零一背包问题
 * 口诀：f[i][j]表示只从前i个物品当中选，且总体积不超过j
 * 根据两个优化条件可以将两维优化成1维
 */
public class BinPackingOne {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int V = arr[1];
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];
        int[][] f = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            v[i] = arr[0];
            w[i] = arr[1];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                if (j - v[i] >= 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(f[N][V]);
    }
}
