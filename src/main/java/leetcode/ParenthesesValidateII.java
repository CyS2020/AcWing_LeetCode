package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: CyS2020
 * @date: 2021/10/10
 * 描述：删除无效的括号
 */
public class ParenthesesValidateII {

    private int len;

    private char[] chars;

    private Set<String> res = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        len = s.length();
        int leftRm = 0;
        int rightRm = 0;
        chars = s.toCharArray();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRm++;
            } else if (c == ')') {
                if (leftRm == 0) {
                    rightRm++;
                } else {
                    leftRm--;
                }
            }
        }
        dfs(0, 0, 0, leftRm, rightRm, "");
        return new ArrayList<>(res);
    }

    private void dfs(int i, int leftVal, int rightVal, int leftRm, int rightRm, String ans) {
        if (i == len) {
            if (leftRm == 0 && rightRm == 0) {
                res.add(ans);
            }
            return;
        }
        char c = chars[i];
        if (c == '(' && leftRm > 0) {
            dfs(i + 1, leftVal, rightVal, leftRm - 1, rightRm, ans);
        }
        if (c == ')' && rightRm > 0) {
            dfs(i + 1, leftVal, rightVal, leftRm, rightRm - 1, ans);
        }

        String tmp = ans + c;
        if (c != '(' && c != ')') {
            dfs(i + 1, leftVal, rightVal, leftRm, rightRm, tmp);
        } else if (c == '(') {
            dfs(i + 1, leftVal + 1, rightVal, leftRm, rightRm, tmp);
        } else if (rightVal < leftVal) {
            dfs(i + 1, leftVal, rightVal + 1, leftRm, rightRm, tmp);
        }
    }
}
