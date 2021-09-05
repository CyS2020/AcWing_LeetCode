package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/8/29
 * 描述：接雨水
 * 思路1：两次遍历分别记录当前位置的左最值与右最值
 * 思路2：单调递减栈，栈顶为左边第一个比当前值大的数
 */
public class HistogramArea {

    // 思路1
    public int trap1(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int max = height[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        max = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            res += min - height[i];
        }
        return res;
    }

    // 思路2
    public int trap2(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int low = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peekLast();
                int right = i;
                int d = i - left - 1;
                int h = Math.min(height[left], height[right]) - height[low];
                res += d * h;
            }
            stack.addLast(i);
        }
        return res;
    }
}
