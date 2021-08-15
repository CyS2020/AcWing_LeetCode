package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/9
 * 描述：正则表达式匹配
 * 思路：
 * 1. 当前i与j相等 => 依赖f[i-1][j-1]
 * 2. 当前j为'.' => 依赖f[i-1][j-1]
 * 3. 当前j为'*' => 若重复0次 依赖f[i][j-2]
 * -------------=> 若重复n次 依赖f[i-1][j]
 * 4. 字符串可以空，正则表达式不能为空
 */
public class RegexMatch {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i > 0 && p.charAt(j - 1) == s.charAt(i - 1)) {
                    f[i][j] |= f[i - 1][j - 1];
                }
                if (i > 0 && p.charAt(j - 1) == '.') {
                    f[i][j] |= f[i - 1][j - 1];
                }
                if (j > 1 && p.charAt(j - 1) == '*') {
                    // 重复0次
                    f[i][j] |= f[i][j - 2];
                    // 重复n次
                    if (i > 0 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
                        f[i][j] |= f[i - 1][j];
                    }
                }
            }
        }
        return f[n][m];
    }
}
