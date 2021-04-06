package chapter3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/4/6
 * 描述：贝尔曼-福特算法
 * 口诀：使用备份更新距离
 */
public class BellmanFord {

    public static int n;

    public static int[] dist;

    public static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        int k = arr[2];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        edges = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int w = arr[2];
            edges.add(new Edge(a, b, w));
        }

        int distance = calcShortestPath(1, n, k);
        System.out.println(distance == -1 ? "impossible" : distance);
    }

    private static int calcShortestPath(int src, int dst, int k) {
        dist[src] = 0;
        int[] backup = new int[n + 1];

        for (int i = 1; i <= k; i++) {
            System.arraycopy(dist, 1, backup, 1, n);
            for (Edge edge : edges) {
                int a = edge.src;
                int b = edge.dst;
                int w = edge.weight;
                if (backup[a] + w < dist[b]) {
                    dist[b] = backup[a] + w;
                }
            }
        }

        return dist[dst] > Integer.MAX_VALUE / 4 ? -1 : dist[dst];
    }

    public static class Edge {
        int src;
        int dst;
        int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }
}
