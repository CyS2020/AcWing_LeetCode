package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/3/3
 * 描述：浮点数二分求立方根
 * 口诀：无边界问题，有精度问题
 */
public class BinaryDouble {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        double x = Double.parseDouble(line);
        double cbrt = binarySearch(x);
        System.out.printf("%.6f%n", cbrt);
    }

    private static double binarySearch(double x) {
        double l = -1 - Math.abs(x);
        double r = 1 + Math.abs(x);
        double eps = 1e-8;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (mid * mid * mid <= x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
