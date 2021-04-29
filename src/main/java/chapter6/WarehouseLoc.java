package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/29
 * 描述：货仓选址
 */
public class WarehouseLoc {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        int loc = arr[N / 2];
        long res = 0;
        for (int i = 0; i < N; i++) {
            res += Math.abs(arr[i] - loc);
        }
        System.out.println(res);
    }
}
