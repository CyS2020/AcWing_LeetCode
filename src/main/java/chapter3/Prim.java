package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/4/7
 * 描述：最小生成树
 * 口诀：更新到连通块的距离
 */
public class Prim {

    public static int n;

    public static int[] dist;

    public static boolean[] st;

    public static int[][] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        weight = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE / 2);
        }
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            addEdge(a, b, w);
            addEdge(b, a, w);
        }

        int weights = calcMinTree();
        System.out.println(weights == -1 ? "impossible" : weights);
    }

    public static int calcMinTree() {
        dist[1] = 0;
        int weights = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            weights += dist[t];
            st[t] = true;
            dist[t] = 0;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && dist[t] + weight[t][j] < dist[j]) {
                    dist[j] = weight[t][j] + dist[t];
                }
            }
        }
        return weights >= Integer.MAX_VALUE / 4 ? -1 : weights;
    }

    public static void addEdge(int a, int b, int w) {
        weight[a][b] = Math.min(weight[a][b], w);
        weight[b][a] = Math.min(weight[b][a], w);
    }
}
