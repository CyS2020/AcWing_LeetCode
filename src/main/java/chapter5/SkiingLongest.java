package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/27
 * 描述：滑雪--记忆化搜索
 */
public class SkiingLongest {

    public static int[] dx = {-1, 0, 1, 0};

    public static int[] dy = {0, 1, 0, -1};

    public static int[][] f;

    public static int[][] s;

    public static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        r = arr[0];
        c = arr[1];
        s = new int[r][c];
        f = new int[r][c];
        for (int i = 0; i < r; i++) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            s[i] = arr;
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res = Math.max(res, skiing(i, j));
            }
        }
        System.out.println(res);
    }

    private static int skiing(int a, int b) {
        // 优化避免TLE
        if (f[a][b] != 0) {
            return f[a][b];
        }
        f[a][b] = 1;
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x >= 0 && x < r && y >= 0 && y < c && s[x][y] < s[a][b]) {
                f[a][b] = Math.max(f[a][b], skiing(x, y) + 1);
            }
        }
        return f[a][b];
    }
}
