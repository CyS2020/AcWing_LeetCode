package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/8/15
 * 描述：进制回文数
 * 思路：先求进制，在判断回文
 */
class PalindromeNBase {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line);
        boolean exist = false;
        for (int i = 2; i <= 16; i++) {
            if (checkPalindrome(nBase(n, i))) {
                exist = true;
                System.out.println(i);
            }
        }
        if (!exist) {
            System.out.println("-1");
        }
    }

    private static String nBase(int v, int base) {
        StringBuilder res = new StringBuilder();
        while (v > 0) {
            int remain = v % base;
            res.append(getDigit(remain));
            v /= base;
        }
        return res.toString();
    }

    private static char getDigit(int v) {
        if (v >= 0 && v <= 9) {
            return (char) ('0' + v);
        } else {
            return (char) ('A' + (v - 10));
        }
    }

    private static boolean checkPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < str.length() && j >= 0) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
