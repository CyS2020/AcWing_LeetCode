package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/18
 * 描述：容斥原理
 * 口诀：奇加偶减，二进制枚举，i < 1 << n; j < n; i >> j & 1
 */
public class Tolerance {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int res = tolerance(n, arr);
        System.out.println(res);
    }

    public static int tolerance(int n, int[] p) {
        int m = p.length;
        int res = 0;
        for (int i = 1; i < 1 << m; i++) {
            int t = 1;
            int s = 0;
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) == 1) {
                    if ((long) t * p[j] > n) {
                        t = -1;
                        break;
                    }
                    t *= p[j];
                    s++;
                }
            }
            if (t != -1) {
                if (s % 2 == 0) {
                    res -= n / t;
                } else {
                    res += n / t;
                }
            }
        }
        return res;
    }
}
