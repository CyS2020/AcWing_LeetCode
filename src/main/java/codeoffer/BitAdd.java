package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/4
 * 描述：使用位运算做加法
 * 思路：模拟计算机加法运算：不进位 + 只进位
 */
public class BitAdd {

    // 迭代实现
    public int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    // 递归实现
    public int dfsAdd(int a, int b){
        if(b == 0){
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return dfsAdd(sum, carry);
    }
}
