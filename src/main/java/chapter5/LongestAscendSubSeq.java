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
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] f = new int[N];
        Arrays.fill(f, 1);
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < i; k++) {
                if (arr[k] < arr[i]) {
                    f[i] = Math.max(f[i], f[k] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, f[i]);
        }

        System.out.println(res);
    }
}
