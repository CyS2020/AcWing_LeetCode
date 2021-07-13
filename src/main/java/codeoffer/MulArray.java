package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/13
 * 描述：构建乘积数组
 * 思路：先算左半边乘积，再算右半边乘积
 */
public class MulArray {

    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        int mul = 1;
        for (int i = 0; i < len; i++) {
            b[i] = mul;
            mul *= a[i];
        }
        mul = 1;
        for (int i = len - 1; i >= 0; i--) {
            b[i] = mul;
            mul *= a[i];
        }
        return b;
    }
}
