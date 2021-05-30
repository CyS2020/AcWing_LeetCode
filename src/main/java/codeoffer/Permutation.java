package codeoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: CyS2020
 * @date: 2021/5/30
 * 描述：字符串全排列
 * 思路：经典dfs问题，注意恢复现场
 */
public class Permutation {

    private Set<String> res = new HashSet<>();

    private boolean[] st;

    private String s;

    public String[] permutation(String s) {
        this.st = new boolean[s.length()];
        this.s = s;
        dfs("", 0);
        return (String[]) res.toArray();
    }

    private void dfs(String tmp, int index) {
        if (index == s.length()) {
            res.add(tmp);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!st[i]) {
                st[i] = true;
                dfs(tmp + s.charAt(i), index + 1);
                st[i] = false;
            }
        }
    }
}
