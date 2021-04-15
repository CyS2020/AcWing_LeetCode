package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/16
 * 描述：欧拉函数
 * 口诀：不整除不等于互素
 */
public class Euler {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int n = Integer.parseInt(line);
            int res = euler(n);
            System.out.println(res);
        }
    }

    public static int euler(int n) {
        int res = n;
        for (int i = 2; i <= n / i; i++) {
            int t = 0;
            while (n % i == 0) {
                t++;
                n /= i;
            }
            if (t > 0) {
                res = res / i * (i - 1);
            }
        }
        if (n > 1) {
            res = res / n * (n - 1);
        }
        return res;
    }
}
