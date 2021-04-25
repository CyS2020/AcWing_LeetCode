package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/25
 * 描述：石子合并
 */
public class MergeStones {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        int[][] f = new int[N + 1][N + 1];
        int[] s = new int[N + 1];
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= N; i++) {
            s[i] = s[i - 1] + arr[i - 1];
        }

        for (int len = 2; len <= N; len++) {
            for (int l = 1; l <= N - len + 1; l++) {
                int r = l + len - 1;
                f[l][r] = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        System.out.println(f[1][N]);
    }
}
