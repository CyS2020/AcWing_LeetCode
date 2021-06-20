package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：最长上升子序列II
 * 二分优化
 */
public class LongestAscentSubseqII {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        int[] s = new int[N + 1];
        int[] p = new int[N + 1];
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(arr, 0, s, 1, N);

        int len = 0;
        for (int i = 1; i <= N; i++) {
            int l = lowerBound(s[i], p, len, i);

            if (l == len) {
                len++;
            }
            p[l + 1] = s[i];
        }

        System.out.println(len);
    }

    private static int lowerBound(int t, int[] p, int len, int i) {
        int l = 0;
        int r = len;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (p[mid] < t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
