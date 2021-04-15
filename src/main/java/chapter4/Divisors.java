package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: CyS2020
 * @date: 2021/4/15
 * 描述：试除法求约束
 * 口诀：可求质数与约束
 */
public class Divisors {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int n = Integer.parseInt(line);
            getDivisors(n);
            System.out.println();
        }
    }

    public static void getDivisors(int n) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        for (int i : set) {
            System.out.print(i + " ");
        }
    }
}
