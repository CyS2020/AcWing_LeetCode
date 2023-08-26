package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/7
 * 描述：弗洛伊德
 * 口诀：d[k, i, j] 表示从 i 到 j，只经过前 k 个点的最短距离
 */
public class Floyd {

    public static int n;

    public static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        int m = arr[1];
        int k = arr[2];
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        while (m-- > 0) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            addEdge(arr[0], arr[1], arr[2]);
        }
        calcShortestPath();
        while (k-- > 0) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            System.out.println(dist[a][b] >= Integer.MAX_VALUE / 4 ? "impossible" : dist[a][b]);
        }
    }

    public static void calcShortestPath() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void addEdge(int a, int b, int c) {
        dist[a][b] = Math.min(dist[a][b], c);
    }
}
