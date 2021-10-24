package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/10/24
 * 描述：字符串解码
 * 思路：使用栈进行状态保存
 */
public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();

        int num = 0;
        StringBuilder tmp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.addLast(num);
                strStack.addLast(tmp);
                num = 0;
                tmp = new StringBuilder();
            } else if (c == ']') {
                String sub = copyString(numStack.pollLast(), tmp.toString());
                tmp = strStack.pollLast().append(sub);
            } else {
                tmp.append(c);
            }
        }
        return tmp.toString();
    }

    public String copyString(int k, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
