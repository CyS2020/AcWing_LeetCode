package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/25
 * 描述：kmp字符串匹配
 * 口诀：初始ne为-1，j之前需匹配，错位平行双指针
 */
public class KMP {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String pattern = input.readLine();
        int m = Integer.parseInt(input.readLine());
        String text = input.readLine();
        // 求ne数组
        int[] ne = new int[n];
        Arrays.fill(ne, -1);
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = ne[j - 1] + 1;
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            ne[i] = j - 1;
        }
        // 匹配模板
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = ne[j - 1] + 1;
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == n) {
                j = ne[j - 1] + 1;
                sb.append(i - n + 1).append(" ");
            }
        }
        System.out.println(sb);
    }
}