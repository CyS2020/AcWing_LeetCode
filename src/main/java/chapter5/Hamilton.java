package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/26
 * 描述：Hamilton路径
 * f[i][j] 从0走到j且走过的点状态为i
 */
public class Hamilton {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        int[][] w = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = input.readLine();
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            w[i] = arr;
        }
        long res = shortestPath(N, w);
        System.out.println(res);
    }

    private static long shortestPath(int n, int[][] w) {
        long[][] f = new long[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }

        f[1][0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        // 从不经过j但是经过k的点转移过来
                        if ((i - (1 << j) >> k & 1) == 1) {
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }

        return f[(1 << n) - 1][n - 1];
    }
}
