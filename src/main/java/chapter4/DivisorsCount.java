package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/4/15
 * 描述：约束个数
 * 口诀：质数幂的乘积
 */
public class DivisorsCount {

    public static int mod = (int) 1e9 + 7;

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int n = Integer.parseInt(line);
            getDivisorsAndCount(n);
        }

        long res = 1;
        for (int v : map.values()) {
            res = res * (v + 1) % mod;
        }
        System.out.println(res);
    }

    public static void getDivisorsAndCount(int n) {
        for (int i = 2; i <= n / i; i++) {
            int t = 0;
            while (n % i == 0) {
                t++;
                n /= i;
            }
            if (t > 0) {
                int v = map.getOrDefault(i, 0);
                t += v;
                map.put(i, t);
            }
        }
        if (n > 1) {
            int v = map.getOrDefault(n, 0);
            map.put(n, v + 1);
        }
    }
}