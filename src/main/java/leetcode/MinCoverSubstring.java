package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述：最小覆盖子串
 * 思路：滑动窗口完成，包含了左边滑动不包含右边滑动
 */
public class MinCoverSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> subMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        String res = "";
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        while (j < chars.length) {
            subMap.put(chars[j], subMap.getOrDefault(chars[j], 0) + 1);
            while (isCover(subMap, tMap)) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                subMap.put(chars[i], subMap.getOrDefault(chars[i], 0) - 1);
                i++;
            }
            j++;
        }
        return res;
    }

    private boolean isCover(Map<Character, Integer> subMap, Map<Character, Integer> tMap) {
        for (Character c : tMap.keySet()) {
            if (!subMap.containsKey(c) || subMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
