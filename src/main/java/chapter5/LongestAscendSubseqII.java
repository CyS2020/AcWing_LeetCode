package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/24
 * 描述：最长上升子序列II
 * 思路：二分优化与桶排序
 */
public class LongestAscendSubseqII {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] p = new int[N + 1];
        int len = 0;
        for (int i = 0; i < N; i++) {
            int l = lowerBound(arr[i], p, len);
            if (l == len) {
                len++;
            }
            p[l + 1] = arr[i];
        }

        System.out.println(len);
    }

    private static int lowerBound(int t, int[] p, int len) {
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
