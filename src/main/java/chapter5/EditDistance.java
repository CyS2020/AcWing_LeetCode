package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/4/25
 * 描述：编辑距离
 */
public class EditDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        List<String> patterns = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            line = input.readLine();
            patterns.add(line);
        }
        for (int i = 1; i <= M; i++) {
            line = input.readLine();
            String[] split = line.split(" ");
            String target = split[0];
            int maxDist = Integer.parseInt(split[1]);

            int res = 0;
            for (String pattern : patterns) {
                int dist = editDistance(target, pattern);
                if (dist <= maxDist) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static int editDistance(String a, String b) {
        int N = a.length();
        int M = b.length();
        int[][] f = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= M; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[N][M];
    }
}
