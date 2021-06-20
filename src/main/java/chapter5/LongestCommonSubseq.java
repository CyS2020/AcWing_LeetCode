package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：最长公共子序列
 */
public class LongestCommonSubseq {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        int[][] f = new int[N + 1][M + 1];
        String a = input.readLine();
        String b = input.readLine();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(f[N][M]);
    }
}
