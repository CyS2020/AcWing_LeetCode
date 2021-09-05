package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述：柱状图中最大的矩形
 * 思路：单调递增栈，栈顶为左边第一个比当前值小的数
 */
public class HistogramAreaII {

    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekLast()]) {
                stack.pollLast();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peekLast() + 1;
            stack.addLast(i);
        }

        stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekLast()]) {
                stack.pollLast();
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peekLast() - 1;
            stack.addLast(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }
        return ans;
    }

    // 一次更新左右两个值
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n - 1);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekLast()]) {
                right[stack.pollLast()] = i - 1;
            }
            left[i] = stack.isEmpty() ? 0 : stack.peekLast() + 1;
            stack.addLast(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
        }
        return ans;
    }
}
