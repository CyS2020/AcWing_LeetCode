import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/14
 * 描述：位运算
 * 口诀：取出k位二进制，返回最后1位置
 */
public class AcWing1_18 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] q = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int value : q) {
            int quantity = OneQuantity(value);
            System.out.print(quantity + " ");
        }
    }

    public static int OneQuantity(int n) {
        int count = 0;
        while (n != 0) {
            n -= (n & -n);
            count++;
        }
        return count;
    }
}
