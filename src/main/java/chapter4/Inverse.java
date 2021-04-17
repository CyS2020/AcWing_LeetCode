package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/17
 * 描述：费马定理求逆元
 */
public class Inverse {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            long[] arr = Arrays.stream(line.split(" ")).mapToLong(Long::parseLong).toArray();
            long a = arr[0];
            long p = arr[1];
            if (a % p == 0) {
                System.out.println("impossible");
            } else {
                long res = inv(a, p - 2, p);
                System.out.println(res);
            }
        }
    }

    public static long inv(long a, long b, long p) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * a % p;
            }
            b >>= 1;
            a = a * a % p;
        }
        return res;
    }
}