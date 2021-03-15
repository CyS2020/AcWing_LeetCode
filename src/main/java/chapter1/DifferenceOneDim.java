package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/8
 * 描述：差分
 * 口诀：全0造差分，个体影响大
 */
public class DifferenceOneDim {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        line = input.readLine();
        arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] s = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            insert(s, i, i, arr[i - 1]);
        }

        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int l = arr[0];
            int r = arr[1];
            int c = arr[2];
            insert(s, l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            s[i] += s[i - 1];
            System.out.print(s[i] + " ");
        }
    }

    public static void insert(int[] s, int l, int r, int c) {
        s[l] += c;
        s[r + 1] -= c;
    }
}
