package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/25
 * 描述：整数划分
 * f[i][j]所有只从前i个数分，总体积正好为j的划分方法
 */
public class PartingInteger {

    public static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);

        int[][] f = new int[N + 1][N + 1];
        f[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k * i <= j; k++) {
                    f[i][j] = (f[i][j] + f[i - 1][j - k * i]) % mod;
                }
            }
        }
        System.out.println(f[N][N]);
    }
}
