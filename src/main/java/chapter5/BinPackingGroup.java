package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：分组背包
 */
public class BinPackingGroup {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int V = arr[1];
        int[][] w = new int[N + 1][101];
        int[][] v = new int[N + 1][101];
        int[] g = new int[N + 1];
        int[][] f = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            line = input.readLine();
            int n = Integer.parseInt(line);
            g[i] = n;
            for (int j = 1; j <= n; j++) {
                line = input.readLine();
                arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                v[i][j] = arr[0];
                w[i][j] = arr[1];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                for (int t = 0; t <= g[i]; t++) {
                    if (j - v[i][t] >= 0) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i][t]] + w[i][t]);
                    }
                }
            }
        }

        System.out.println(f[N][V]);
    }
}
