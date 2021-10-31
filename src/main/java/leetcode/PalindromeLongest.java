package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/8/15
 * 描述：最长回文子串
 * 思路：对奇数偶数分别求一次取最长的子串
 */
public class PalindromeLongest {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (res.length() < r - l - 1) {
                res = s.substring(l + 1, r);
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (res.length() < r - l - 1) {
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }
}
