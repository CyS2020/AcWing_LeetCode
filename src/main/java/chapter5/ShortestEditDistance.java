package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: CyS2020
 * @date: 2021/4/25
 * 描述：最短编辑距离
 * f[i][j]表示a以i结尾，b以j结尾匹配所花费的最少次数
 */
public class ShortestEditDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int N = Integer.parseInt(line);
        String a = input.readLine();
        line = input.readLine();
        int M = Integer.parseInt(line);
        String b = input.readLine();

        int[][] f = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= M; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                f[i][j] = Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(f[N][M]);
    }
}
