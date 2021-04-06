package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/6
 * 描述：朴素Dijkstra
 * 口诀：寻找目标更新距离
 */
public class DijkstraPlain {

    public static int[][] weight;

    public static int[] dist;

    public static boolean[] st;

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        weight = new int[n + 1][n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE / 2);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            addEdge(a, b, w);
        }

        int distance = calcShortestDist(1, n);
        System.out.println(distance);
    }

    private static int calcShortestDist(int src, int dst) {
        dist[src] = 0;

        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if ((t == -1 || dist[j] < dist[t]) && !st[j]) {
                    t = j;
                }
            }
            // 提前结束寻路
            if (t == dst) {
                break;
            }
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                if (dist[t] + weight[t][j] < dist[j]) {
                    dist[j] = dist[t] + weight[t][j];
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE / 2 ? -1 : dist[dst];
    }

    public static void addEdge(int a, int b, int w) {
        weight[a][b] = Math.min(weight[a][b], w);
    }
}
