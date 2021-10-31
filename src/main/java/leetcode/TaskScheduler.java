package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/10/31
 * 描述：任务调度器
 * 思路：(maxExec - 1)(n + 1) + maxCount和tasks中的较大值。
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int maxExec = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            maxExec = Math.max(maxExec, count);
        }

        int maxCount = 0;
        for (Integer count : map.values()) {
            if (count == maxExec) {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
