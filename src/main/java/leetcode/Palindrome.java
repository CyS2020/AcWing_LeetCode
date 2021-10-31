package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/31
 * 描述：回文子串
 * 思路：区间DP
 */
public class Palindrome {

    public int countSubstrings(String s) {
        int N = s.length();
        int count = 0;
        boolean[][] f = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = true;
            count++;
        }
        for (int len = 2; len <= N; len++) {
            for (int l = 0; l < N - len + 1; l++) {
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r) && (len == 2 || f[l + 1][r - 1])) {
                    f[l][r] = true;
                    count++;

                }
            }
        }
        return count;
    }
}
