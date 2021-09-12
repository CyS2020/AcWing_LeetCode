package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: CyS2020
 * @date: 2021/9/12
 * 描述：最长连续序列
 * 思路：使用set集合, 从最小的开始加, 然后查看set集合有没有后面序列的值
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curLen = 1;
                while (set.contains(num + 1)) {
                    curLen += 1;
                    num += 1;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
