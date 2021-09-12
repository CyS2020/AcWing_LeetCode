package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：单词拆分
 * 思路：动态规划，以i结尾的能拆分单词, 枚举0 - i进行拆分检验
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String str : wordDict) {
            set.add(str);
            minLen = Math.min(minLen, str.length());
            maxLen = Math.max(maxLen, str.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = minLen; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (i - j > maxLen || i - j < minLen) {
                    continue;
                }
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = dp[j] && set.contains(s.substring(j, i));
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
