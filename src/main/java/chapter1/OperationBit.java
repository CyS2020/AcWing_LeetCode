package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/14
 * 描述：位运算-二进制中1个数
 * 口诀：取出k位二进制，返回最后1位置
 */
public class OperationBit {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : q) {
            int quantity = oneQuantity(value);
            System.out.print(quantity + " ");
        }
    }

    public static int oneQuantity(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
