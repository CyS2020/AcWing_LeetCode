package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/17
 * 描述：高斯消元
 * 口诀：找到列的最大数，交换该行到顶部，首位需要化成1，扩大倍数消为0
 */
public class Gauss {

    public static double eps = 1e-5;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        double[][] a = new double[n][n + 1];
        int r = 0;
        while ((line = input.readLine()) != null) {
            double[] arr = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
            a[r++] = arr;
        }
        int res = gauss(a);
        if (res == -1) {
            System.out.println("No solution");
        } else if (res == 2) {
            System.out.println("Infinite group solutions");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(String.format("%.2f", a[i][n]));
            }
        }
    }

    public static int gauss(double[][] a) {
        int row = a.length - 1;
        int col = a[0].length - 1;
        int r, c;
        double mul;
        for (r = 0, c = 0; c < col; c++) {
            int t = r;
            for (int i = r + 1; i <= row; i++) {
                if (a[i][c] > a[t][c]) {
                    t = i;
                }
            }

            if (Math.abs(a[t][c]) < eps) {
                continue;
            }

            swap(a, t, r);

            mul = a[r][c];
            for (int j = 0; j <= col; j++) {
                a[r][j] /= mul;
            }

            for (int i = r + 1; i <= row; i++) {
                mul = a[i][c];
                for (int j = c; j <= col; j++) {
                    a[i][j] -= mul * a[r][j];
                }
            }

            r++;
        }

        if (r <= row) {
            for (int i = r; i <= row; i++) {
                if (Math.abs(a[i][col]) > eps) {
                    return -1;
                }
            }
            return 2;
        }

        for (int i = row; i >= 0; i--) {
            for (int j = i + 1; j < col; j++) {
                mul = a[i][j];
                a[i][col] -= mul * a[j][col];
            }
        }

        return 1;
    }

    public static void swap(double[][] a, int t, int r) {
        for (int j = 0; j < a[0].length; j++) {
            double tmp = a[t][j];
            a[t][j] = a[r][j];
            a[r][j] = tmp;
        }
    }
}
