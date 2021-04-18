package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/18
 * 描述：卡塔兰数
 */
public class CatalanMath {

    public static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        long res = catalanMath(n);
        System.out.println(res);
    }

    public static long catalanMath(int n) {
        long fact = 1;
        long invFact = 1;
        for (int i = 1, j = 2 * n; i <= n; i++, j--) {
            fact = fact * j % mod;
            invFact = invFact * inv(i, mod - 2, mod) % mod;
        }
        return fact * invFact % mod * inv(n + 1, mod - 2, mod) % mod;
    }

    public static long inv(int t, int b, int p) {
        long res = 1;
        long a = t;
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
