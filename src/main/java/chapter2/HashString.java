package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/3
 * 描述：字符串哈希
 * 口诀：
 */
public class HashString {

    private final long[] hash;

    private final long[] pow;

    private final int P = 131;

    private final long Q = Long.MAX_VALUE;

    public HashString(String str) {
        hash = new long[str.length() + 1];
        pow = new long[str.length() + 1];
        initial(str);
    }

    private void initial(String str) {
        pow[0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            int c = str.charAt(i - 1);
            pow[i] = pow[i - 1] * P;
            hash[i] = (hash[i - 1] * P + c) % Q;
        }
    }

    public long subHash(int l, int r) {
        return hash[r + 1] - hash[l] * pow[r - l + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        line = input.readLine();
        HashString hash = new HashString(line);
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (hash.subHash(arr[0] - 1, arr[1] - 1) == hash.subHash(arr[2] - 1, arr[3] - 1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
