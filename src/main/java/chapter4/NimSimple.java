package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/18
 * 描述：Nim游戏
 * 口诀：异或为0先手必败
 */
public class NimSimple {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int i : arr) {
            res ^= i;
        }
        System.out.println(res == 0 ? "No" : "Yes");
    }
}
