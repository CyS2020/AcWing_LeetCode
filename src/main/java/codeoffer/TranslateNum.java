package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/6/20
 * 描述：把数字翻译成字符串
 * 口诀：动态规划，初始值为1
 */
public class TranslateNum {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int N = str.length();
        int[] f = new int[N + 1];
        f[0] = 1;
        for (int i = 1; i <= N; i++) {
            f[i] = f[i - 1];
            if (i > 1) {
                int a = str.charAt(i - 2) - '0';
                int b = str.charAt(i - 1) - '0';
                int t = a * 10 + b;
                if (t >= 10 && t <= 25) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[N];
    }
}
