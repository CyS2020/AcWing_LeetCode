package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：最长上升子序列
 */
public class LongestAscendSubSeq {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        int[] f = new int[N + 1];
        int[] s = new int[N + 1];
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(arr, 0, s, 1, N);

        for (int i = 1; i <= N; i++) {
            f[i] = 1;
            for (int k = 1; k < i; k++) {
                if (s[k] < s[i]) {
                    f[i] = Math.max(f[i], f[k] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, f[i]);
        }

        System.out.println(res);
    }
}
