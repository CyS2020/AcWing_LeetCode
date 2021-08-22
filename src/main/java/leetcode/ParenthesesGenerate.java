package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/8/22
 * 描述：括号生成
 * 思路：
 */
public class ParenthesesGenerate {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return res;
    }

    public void dfs(int n, String str, int l, int r) {
        if (l == n && r == n) {
            res.add(str);
        }

        if (l < n) {
            dfs(n, str + "(", l + 1, r);
        }

        if (l > r && r < n) {
            dfs(n, str + ")", l, r + 1);
        }
    }
}