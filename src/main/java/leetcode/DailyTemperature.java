package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/10/28
 * 描述：每日温度
 * 思路：单调递减栈
 */
public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peekFirst()]) {
                stack.pollFirst();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peekFirst() - i;
            stack.addFirst(i);
        }
        return res;
    }
}
