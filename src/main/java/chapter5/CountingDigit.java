package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/4/25
 * 描述：计数问题
 * 口诀：枚举已在中位时，高位不动中低最大，大于中位取最大，等于中位取低加1(0的从次高来枚举，再减中低最大值)
 */
public class CountingDigit {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = Math.max(arr[0], arr[1]);
            int b = Math.min(arr[0], arr[1]);
            if (a == 0 && b == 0) {
                break;
            }

            for (int i = 0; i <= 9; i++) {
                int res = countingDigit(a, i) - countingDigit(b - 1, i);
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    public static int countingDigit(int n, int x) {
        if (n == 0) {
            return 0;
        }
        LinkedList<Integer> bits = new LinkedList<>();
        while (n > 0) {
            bits.addFirst(n % 10);
            n /= 10;
        }

        int len = bits.size() - 1;
        int res = 0;
        int t = x == 0 ? 1 : 0;
        for (int i = t; i < bits.size(); i++) {
            if (i > 0) {
                res += getValue(0, i - 1, bits) * Math.pow(10, len - i);
                if (x == 0) {
                    res -= Math.pow(10, len - i);
                }
            }
            if (bits.get(i) > x) {
                res += Math.pow(10, len - i);
            }
            if (bits.get(i) == x) {
                res += getValue(i + 1, len, bits) + 1;
            }
        }
        return res;
    }

    private static int getValue(int l, int r, LinkedList<Integer> bits) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res = res * 10 + bits.get(i);
        }
        return res;
    }
}
