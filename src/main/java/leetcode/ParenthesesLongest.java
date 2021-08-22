package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/8/22
 * 描述：最长有效括号
 * 思路：使用栈数据结构，并且栈底保存有效括号的分隔线位置，该位置之后为有效括号
 * 栈底存储分割线的位置, 初始值为 -1
 */
public class ParenthesesLongest {

    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.addLast(i);
                } else {
                    max = Math.max(max, i - stack.peekLast());
                }
            }
        }
        return max;
    }
}
