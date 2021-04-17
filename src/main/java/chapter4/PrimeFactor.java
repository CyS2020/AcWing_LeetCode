package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/15
 * 描述：分解质因数
 * 口诀：除尽当前质因子
 */
public class PrimeFactor {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int n = Integer.parseInt(line);
            getDivisors(n);
        }
    }

    public static void getDivisors(int n) {
        for (int i = 2; i <= n / i; i++) {
            int t = 0;
            while (n % i == 0) {
                n /= i;
                t++;
            }
            if (t > 0) {
                System.out.println(i + " " + t);
            }
        }
        if (n > 1) {
            System.out.println(n + " " + 1);
        }
        System.out.println();
    }
}