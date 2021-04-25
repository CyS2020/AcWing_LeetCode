package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/4/25
 * 描述：计数问题
 */
public class CountingDigit {

    public static Map<Integer, Integer> pow = new HashMap<>();

    public static void main(String[] args) throws IOException {

        int s = 1;
        for (int i = 0; i <= 9; i++) {
            pow.put(i, s);
            s *= 10;
        }

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
        LinkedList<Integer> digits = new LinkedList<>();
        while (n > 0) {
            digits.addFirst(n % 10);
            n /= 10;
        }

        int N = digits.size() - 1;
        int res = 0;
        int t = x == 0 ? 1 : 0;
        for (int i = t; i < digits.size(); i++) {
            int mi = N - i;
            if (i > 0) {
                res += getValue(0, i - 1, digits) * pow.get(mi);
                if (x == 0) {
                    res -= pow.get(mi);
                }
            }
            if (digits.get(i) > x) {
                res += pow.get(mi);
            } else if (digits.get(i) == x) {
                res += getValue(i + 1, N, digits) + 1;
            }
        }
        return res;
    }

    private static int getValue(int l, int r, LinkedList<Integer> digits) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res = res * 10 + digits.get(i);
        }
        return res;
    }
}
