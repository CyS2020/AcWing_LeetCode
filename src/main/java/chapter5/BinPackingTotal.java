package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：完全背包
 */
public class BinPackingTotal {

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
                for (int k = 0; k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }

        System.out.println(f[N][V]);
    }
}
