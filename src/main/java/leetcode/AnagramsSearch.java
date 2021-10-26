package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/10/26
 * 描述：找到字符串中所有字母异位词
 * 思路：滑动窗口与双指针
 */
public class AnagramsSearch {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        for (char c : p.toCharArray()) {
            pCnt[c - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int val = s.charAt(r) - 'a';
            sCnt[val]++;
            while (sCnt[val] > pCnt[val]) {
                sCnt[s.charAt(l) - 'a']--;
                l++;
            }
            if (r - l + 1 == p.length()) {
                res.add(l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        AnagramsSearch search = new AnagramsSearch();
        System.out.println(search.findAnagrams(s, p));
    }
}
