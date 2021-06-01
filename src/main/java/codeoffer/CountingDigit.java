package codeoffer;

import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/6/1
 * 描述：计数DP
 * 思路：枚举已在中位时，高位不动中低最大，大于中位取最大，等于中位取低加1(0的从次高来枚举，再减中低最大值)
 */
public class CountingDigit {

    public int countDigitOne(int n) {
        LinkedList<Integer> bits = new LinkedList<>();
        while (n > 0) {
            bits.addFirst(n % 10);
            n /= 10;
        }

        int cnt = 0;
        int len = bits.size() - 1;
        for (int i = 0; i < bits.size(); i++) {
            if (i > 0) {
                cnt += getValue(0, i - 1, bits) * Math.pow(10, len - i);
            }
            if (bits.get(i) > 1) {
                cnt += Math.pow(10, len - i);
            }
            if (bits.get(i) == 1) {
                cnt += getValue(i + 1, len, bits) + 1;
            }
        }
        return cnt;
    }

    private int getValue(int l, int r, LinkedList<Integer> bits) {
        int val = 0;
        for (int i = l; i <= r; i++) {
            val = val * 10 + bits.get(i);
        }
        return val;
    }
}
