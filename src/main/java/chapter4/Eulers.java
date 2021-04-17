package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/17
 * 描述：筛法求欧拉函数
 */
public class Eulers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        long sum = eulers(n);
        System.out.println(sum);
    }

    public static long eulers(int n) {
        int cnt = 0;
        int[] primes = new int[n + 1];
        int[] euler = new int[n + 1];
        euler[1] = 1;
        boolean[] st = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                euler[i] = i - 1;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    euler[primes[j] * i] = primes[j] * euler[i];
                    break;
                }
                euler[primes[j] * i] = (primes[j] - 1) * euler[i];
            }
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += euler[i];
        }
        return sum;
    }
}
