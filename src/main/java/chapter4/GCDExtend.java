package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/17
 * 描述：扩展欧几里得
 * 口诀：ax + by = gcd(a, b) = d; 求一组x, y的解
 */
public class GCDExtend {

    public static int x;

    public static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int d = exgcd(a, b);
            System.out.println(x + " " + y);
        }
    }

    public static int exgcd(int a, int b) {
        if (b == 0) {
            y = 0;
            x = 1;
            return a;
        }
        int d = exgcd(b, a % b);
        int ox = x;
        x = y;
        y = ox - (a / b) * y;
        return d;
    }
}
