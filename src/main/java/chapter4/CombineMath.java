package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/18
 * 描述：组合数
 * 口诀：使用Dp
 */
public class CombineMath {

    public static int mod = (int) 1e9 + 7;

    public static int N = 2000;

    public static void main(String[] args) throws IOException {
        int[][] res = combineMath(N, N);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            System.out.println(res[a][b]);
        }
    }

    public static int[][] combineMath(int a, int b) {
        int[][] cab = new int[a + 1][b + 1];
        cab[0][0] = 1;
        for (int i = 1; i <= a; i++) {
            cab[i][0] = 1;
            for (int j = 1; j <= i && j <= b; j++) {
                cab[i][j] = (cab[i - 1][j - 1] + cab[i - 1][j]) % mod;
            }
        }
        return cab;
    }
}
