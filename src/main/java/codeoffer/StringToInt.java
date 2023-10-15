package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/14
 * 描述：把字符串转换成整数
 * 思路：主要是细心加边界的判断
 */
public class StringToInt {

    public int strToInt(String str) {
        str = str.trim();
        int k = 0;
        boolean minus = false;
        if (k < str.length() && str.charAt(k) == '+') {
            k++;
        } else if (k < str.length() && str.charAt(k) == '-') {
            k++;
            minus = true;
        }
        long num = 0;
        while (k < str.length() && str.charAt(k) >= '0' && str.charAt(k) <= '9') {
            num = num * 10 + str.charAt(k) - '0';
            if (num > Integer.MAX_VALUE && minus) {
                return Integer.MIN_VALUE;
            }
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            k++;
        }
        if (minus) {
            num = -num;
        }
        return (int) num;
    }
}
