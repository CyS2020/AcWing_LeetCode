package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：数字三角形
 */
public class DigitalTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        int[][] g = new int[n + 1][n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            line = input.readLine();
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(arr, 0, g[i], 1, i);
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + g[i][j];
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);
    }
}
