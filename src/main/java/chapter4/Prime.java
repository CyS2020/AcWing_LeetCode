package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/15
 * 描述：试除法判断质数
 * 口诀：可求质数与约束
 */
public class Prime {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int n = Integer.parseInt(line);
            boolean st = isPrime(n);
            System.out.println(st ? "Yes" : "No");
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
