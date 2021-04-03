package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/3
 * 描述：字符串匹配
 * 口诀：使用KMP或者字符串哈希
 */
public class PatternMatch {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String pattern = input.readLine();
        int m = Integer.parseInt(input.readLine());
        String text = input.readLine();

        HashString patternHash = new HashString(pattern);
        HashString textHash = new HashString(text);
        long hash = patternHash.subHash(0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m - n + 1; i++) {
            long subHash = textHash.subHash(i, i + n - 1);
            if (hash == subHash) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}