package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/17
 * 描述：线性同余方程
 */
public class Remainder {

    public static int x;

    public static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int m = arr[2];
            int d = exgcd(a, m);
            if (b % d != 0) {
                System.out.println("impossible");
            } else {
                long res = (long) x * b / d % m;
                System.out.println(res);
            }
        }
    }

    public static int exgcd(int a, int b) {
        if (b == 0) {
            y = 0;
            x = 1;
            return a;
        }
        int d = exgcd(b, a % b);
        int ox = x;
        x = y;
        y = ox - (a / b) * y;
        return d;
    }
}