package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/15
 * 描述：线性筛素数
 */
public class Primes {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        int cnt = getPrimes(n);
        System.out.println(cnt);
    }

    public static int getPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int cnt = 0;
        int[] prime = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                prime[cnt++] = i;
            }
            for (int j = 0; prime[j] <= n / i; j++) {
                st[prime[j] * i] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        return cnt;
    }
}
