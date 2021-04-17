package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/17
 * 描述：快速幂
 */
public class QuickPow {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int p = arr[2];
            long res = quickPow(a, b, p);
            System.out.println(res);
        }
    }

    private static long quickPow(int t, int b, int p) {
        long res = 1;
        long a = t;
        while (b != 0) {
            if ((b & 1) == 1) res = res * a % p;
            b >>= 1;
            a = a * a % p;
        }
        return res;
    }
}