package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/12
 * 描述：表示数值的字符串
 * 思路：指针与状态转移，整数小数科学数
 */
public class IsNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        int len = s.length();
        int i = 0;
        boolean st = false;
        // 处理整数
        while (i < len && Character.isDigit(s.charAt(i))) {
            st = true;
            i++;
        }
        // 处理小数
        if (i < len && s.charAt(i) == '.') {
            i++;
        }
        while (i < len && Character.isDigit(s.charAt(i))) {
            st = true;
            i++;
        }
        // 处理科学计数
        if (i < len && st && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            st = false;
            i++;
            if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < len && Character.isDigit(s.charAt(i))) {
                st = true;
                i++;
            }
        }
        return i == len && st;
    }
}
