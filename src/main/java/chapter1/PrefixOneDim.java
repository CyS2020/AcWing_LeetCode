package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/8
 * 描述：前缀和
 * 口诀：一维减区间，二维减区域，下标从1始
 */
public class PrefixOneDim {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        line = input.readLine();
        arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] a = new int[n + 1];
        System.arraycopy(arr, 0, a, 1, n);

        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int l = arr[0];
            int r = arr[1];
            int k = s[r] - s[l - 1];
            System.out.println(k);
        }
    }
}
