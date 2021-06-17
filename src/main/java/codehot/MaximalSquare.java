package codehot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/6/16
 * 描述：最大正方形
 * 思路：相邻的最小值决定了该位置的值
 */
public class MaximalSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = input.readLine();
            arr[i] = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
        }

        int maxLen = maximalLength(arr);
        System.out.println(maxLen * maxLen);
    }

    private static int maximalLength(int[][] arr) {
        int maxLen = 0;
        int N = arr.length;
        int M = arr[0].length;
        int[][] f = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i - 1][j - 1] == 1) {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }
                maxLen = Math.max(maxLen, f[i][j]);
            }
        }
        return maxLen;
    }
}
