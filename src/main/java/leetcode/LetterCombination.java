package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/8/15
 * 描述：电话号码的组合
 * 思路：dfs确定好终止条件，dfs函数中能提出来全局变量的尽量提出来，参数列表更加简洁
 */
public class LetterCombination {

    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, "", 0);
        return res;
    }

    private void dfs(String digits, String ans, int index) {
        if (index >= digits.length()) {
            res.add(ans);
            return;
        }

        String alphabet = strs[digits.charAt(index) - '0'];
        for (char c : alphabet.toCharArray()) {
            dfs(digits, ans + c, index + 1);
        }
    }
}
