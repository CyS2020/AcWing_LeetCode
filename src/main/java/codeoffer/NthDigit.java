package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/6/3
 * 描述：数字序列中的某一位数字
 * 思路：
 * 1.确定是几位数，n - 10 - 90*2 - 900*3
 * 2.确定几位数的第几个数，n / l上取整
 * 3.确定该数的第几位，除去剩下的10
 */
public class NthDigit {

    public int findNthDigit(int n) {
        long len = 1;     //位数长度，1,2,3
        long cnt = 9;     //位数个数，10，90
        long base = 1;    //len位数的最小值
        while (n > len * cnt) {
            n -= len * cnt;
            len++;
            cnt *= 10;
            base *= 10;
        }
        long num = base + (n + len - 1) / len - 1;
        long mod = n % len == 0 ? len : n % len;
        for (int i = 0; i < len - mod; i++) {
            num /= 10;
        }
        return (int) num % 10;
    }
}
