package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/8/22
 * 描述：有效的括号
 * 思路：使用栈数据结构
 */
public class ParenthesesValidate {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                Character poll = stack.pollLast();
                if (poll != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
