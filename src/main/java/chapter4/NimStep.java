package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/18
 * 描述：台阶Nim游戏
 */
public class NimStep {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (i % 2 == 1) {
                res ^= arr[i - 1];
            }
        }
        System.out.println(res == 0 ? "No" : "Yes");
    }
}
