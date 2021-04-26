package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/26
 * 描述：蒙德里安的梦想
 * f[i][j]表示摆放了前i行且第i行的状态为j的所有集合
 */
public class SplitGrid {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = arr[0];
            int col = arr[1];
            if (row == 0 && col == 0) {
                break;
            }
            long res = dream(row, col);
            System.out.println(res);
        }
    }

    public static long dream(int n, int m) {
        boolean[] st = new boolean[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            st[i] = true;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 0) {
                    cnt++;
                } else if (cnt % 2 == 1) {
                    break;
                }
            }
            if (cnt % 2 == 1) {
                st[i] = false;
            }
        }

        long[][] f = new long[m + 1][1 << n];
        f[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                for (int k = 0; k < 1 << n; k++) {
                    if ((k & j) == 0 && st[j | k]) {
                        f[i][j] += f[i - 1][k];
                    }
                }
            }
        }
        return f[m][0];
    }
}
